package com.example.pokeinfo.features.main

import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokeinfo.core.base.BaseActivity
import com.example.pokeinfo.databinding.ActivityMainBinding
import com.example.pokeinfo.features.main.adater.PokemonCardAdapter
import com.example.pokeinfo.utils.decoration.ItemGridDecorator
import com.example.pokeinfo.utils.dpToPixel
import com.example.pokeinfo.utils.showToast
import dagger.hilt.android.AndroidEntryPoint
import org.orbitmvi.orbit.viewmodel.observe

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val mainViewModel: MainViewModel by viewModels()
    override fun initBinding(layoutInflater: LayoutInflater): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setRecyclerView()
        getData()
    }

    override fun setObserver() {
        super.setObserver()
        mainViewModel.observe(lifecycleOwner = this, state = ::render, sideEffect = ::handleSideEffect)
    }

    private fun setRecyclerView() {
        binding.recyclerView.apply {
            adapter = PokemonCardAdapter()
            layoutManager = GridLayoutManager(context, 2)
            addItemDecoration(
                ItemGridDecorator(
                    spanCount = 2,
                    topMargin = 0.dpToPixel(),
                    bottomMargin = 0.dpToPixel(),
                    startMargin = 0.dpToPixel(),
                    endMargin = 0.dpToPixel(),
                    middleVerticalMargin = 8.dpToPixel(),
                    middleHorizontalMargin = 8.dpToPixel()
                )
            )
        }
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