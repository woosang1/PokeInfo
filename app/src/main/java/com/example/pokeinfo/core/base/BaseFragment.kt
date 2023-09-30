package com.example.pokeinfo.core.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

open abstract class BaseFragment<VDB : ViewDataBinding> : Fragment() {
    private lateinit var _binding : VDB
    val binding : VDB get() = _binding

    open fun onInitBinding() {}
    open fun setObserver() {}

    abstract fun initBinding(layoutInflater: LayoutInflater) : VDB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = initBinding(layoutInflater = layoutInflater)
        _binding.lifecycleOwner = this
        onInitBinding()
        setObserver()
    }

}
