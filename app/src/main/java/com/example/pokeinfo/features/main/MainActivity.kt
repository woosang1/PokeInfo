package com.example.pokeinfo.features.main

import android.os.Bundle
import androidx.activity.viewModels
import com.example.pokeinfo.R
import com.example.pokeinfo.core.base.BaseActivity
import com.example.pokeinfo.utils.showToast
import org.orbitmvi.orbit.viewmodel.observe

class MainActivity : BaseActivity() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setObserve()
        getData()
    }

    private fun setObserve(){
        mainViewModel.observe(lifecycleOwner = this, state = ::render, sideEffect = ::handleSideEffect)
    }

    private fun render(state: MainState) {
        when (state) {
            is MainState.Info -> {

            }
            is MainState.Empty -> {

            }
        }
    }

    private fun handleSideEffect(mainSideEffect: MainSideEffect){
        when(mainSideEffect){
            is MainSideEffect.ShowToast -> {
                showToast(mainSideEffect.message)
            }
        }
    }

    private fun getData(){
        mainViewModel.getInfoData(limit = 0, offset = 0)
    }

}