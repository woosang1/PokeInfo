package com.example.pokeinfo.core.base

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ViewDataBinding

open abstract class BaseActivity<VDB : ViewDataBinding> : AppCompatActivity(){

    private lateinit var _binding : VDB
    val binding : VDB get() = _binding

    open fun onInitBinding() {}
    open fun setObserver() {}

    abstract fun initBinding(layoutInflater: LayoutInflater) : VDB

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        _binding = initBinding(layoutInflater = layoutInflater)
        setContentView(binding.root)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = initBinding(layoutInflater = layoutInflater)
        _binding.lifecycleOwner = this
        setContentView(binding.root)
        onInitBinding()
        setObserver()
    }

}
