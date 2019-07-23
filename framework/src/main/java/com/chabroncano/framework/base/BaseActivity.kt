package com.chabroncano.framework.base

import android.arch.lifecycle.ViewModel
import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

abstract class BaseActivity<VM: ViewModel, DB: ViewDataBinding>: AppCompatActivity() {

    private var binding: DB? = null

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        setView(setupLayoutId())
    }

    abstract fun setupLayoutId(): Int

    private fun setView(layoutId: Int) {
        binding = DataBindingUtil.setContentView(this, layoutId)
    }

    fun getView(): DB? = binding

    // TODO: Initialization of ViewModel
}