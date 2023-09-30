package com.example.pokeinfo.features.main.screen

import android.util.Log
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokeinfo.core.base.BaseActivity
import com.example.pokeinfo.databinding.ActivityMainBinding
import com.example.pokeinfo.features.detail.DetailActivity
import com.example.pokeinfo.features.main.common.MainInfoState
import com.example.pokeinfo.features.main.common.MainSideEffect
import com.example.pokeinfo.features.main.common.MainState
import com.example.pokeinfo.features.main.MainViewModel
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

    override fun onInitBinding(){
        setRecyclerView()
        getData()
    }

    override fun setObserver() {
        super.setObserver()
        mainViewModel.observe(lifecycleOwner = this, state = ::render, sideEffect = ::handleSideEffect)
    }

    private fun setRecyclerView() {
        binding.recyclerView.apply {
            adapter = PokemonCardAdapter(mainViewModel)
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
        Log.d("logger" , "render : state ${state.toString()}")
        when (state.mainInfoState) {
            is MainInfoState.Info -> {
                (binding.recyclerView.adapter as? PokemonCardAdapter)?.addData(state.mainInfoState.infoList)
            }
            is MainInfoState.Empty -> {

            }
        }
    }

    private fun handleSideEffect(mainSideEffect: MainSideEffect){
        when(mainSideEffect){
            is MainSideEffect.ShowToast -> {
                showToast(mainSideEffect.message)
            }
            is MainSideEffect.StartDetailActivity -> {
                Log.d("logger" , "is MainSideEffect.StartDetailActivity -> {")
                DetailActivity.start(this@MainActivity, mainSideEffect.id)
            }
        }
    }

    private fun getData(){
        mainViewModel.getInfoData(limit = 0, offset = 0)
    }

}