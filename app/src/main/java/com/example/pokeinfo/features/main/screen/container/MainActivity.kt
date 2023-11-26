package com.example.pokeinfo.features.main.screen.container

import android.util.Log
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokeinfo.R
import com.example.pokeinfo.core.base.BaseActivity
import com.example.pokeinfo.core.ui.bottomSheet.BottomSheetManager
import com.example.pokeinfo.core.ui.bottomSheet.BottomSheetType
import com.example.pokeinfo.databinding.ActivityMainBinding
import com.example.pokeinfo.features.detail.screen.container.DetailActivity
import com.example.pokeinfo.features.main.common.MainInfoState
import com.example.pokeinfo.features.main.common.MainSideEffect
import com.example.pokeinfo.features.main.common.MainState
import com.example.pokeinfo.features.main.viewModel.MainViewModel
import com.example.pokeinfo.features.main.screen.adater.PokemonCardAdapter
import com.example.pokeinfo.utils.decoration.ItemGridDecorator
import com.example.pokeinfo.utils.dpToPixel
import com.example.pokeinfo.utils.showToast
import com.leinardi.android.speeddial.SpeedDialView
import dagger.hilt.android.AndroidEntryPoint
import org.orbitmvi.orbit.viewmodel.observe

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val mainViewModel: MainViewModel by viewModels()

    override fun initBinding(layoutInflater: LayoutInflater): ActivityMainBinding =
        ActivityMainBinding.inflate(layoutInflater)

    override fun onInitBinding() {
        setRecyclerView()
        setSpeedDialView()
        getData()
    }

    override fun setObserver() {
        super.setObserver()
        mainViewModel.observe(
            lifecycleOwner = this,
            state = ::render,
            sideEffect = ::handleSideEffect
        )
    }

    private fun render(state: MainState) {
        Log.d("logger", "render : state ${state.toString()}")
        when (state.mainInfoState) {
            is MainInfoState.Info -> {
                (binding.recyclerView.adapter as? PokemonCardAdapter)?.addData(state.mainInfoState.infoList)
            }

            is MainInfoState.Empty -> {

            }
        }
    }

    private fun handleSideEffect(mainSideEffect: MainSideEffect) {
        when (mainSideEffect) {
            is MainSideEffect.ShowFavoriteBottomSheet -> {
                val bottomSheet = BottomSheetManager(BottomSheetType.FAVORITE)
                bottomSheet.show(supportFragmentManager, bottomSheet.tag)
            }

            is MainSideEffect.ShowAllTypeBottomSheet -> {
                val bottomSheet = BottomSheetManager(BottomSheetType.ALL_TYPE)
                bottomSheet.show(supportFragmentManager, bottomSheet.tag)
            }

            is MainSideEffect.ShowGenerationsBottomSheet -> {
                val bottomSheet = BottomSheetManager(BottomSheetType.GENERATIONS)
                bottomSheet.show(supportFragmentManager, bottomSheet.tag)
            }

            is MainSideEffect.ShowSearchBottomSheet -> {
                val bottomSheet = BottomSheetManager(BottomSheetType.SEARCH)
                bottomSheet.show(supportFragmentManager, bottomSheet.tag)
            }

            is MainSideEffect.ShowToast -> {
                showToast(mainSideEffect.message)
            }

            is MainSideEffect.StartDetailActivity -> {
                DetailActivity.start(this@MainActivity, mainSideEffect.pokemonInfo)
            }
        }
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

    private fun setSpeedDialView() {
        binding.speedDial.inflate(R.menu.menu_pokedex)
        binding.speedDial.setOnActionSelectedListener(SpeedDialView.OnActionSelectedListener { actionItem ->
            when (actionItem.id) {

                R.id.menuFavorite -> {
                    mainViewModel.showFavoriteBottomSheet()
                    binding.speedDial.close()
                    return@OnActionSelectedListener true
                }

                R.id.menuAllType -> {
                    mainViewModel.showAllTypeBottomSheet()
                    binding.speedDial.close()
                    return@OnActionSelectedListener true
                }


                R.id.menuAllGen -> {
                    mainViewModel.showGenerationsBottomSheet()
                    binding.speedDial.close()
                    return@OnActionSelectedListener true
                }

                R.id.menuSearch -> {
                    mainViewModel.showSearchBottomSheet()
                    binding.speedDial.close()
                    return@OnActionSelectedListener true
                }

                else -> {
                    binding.speedDial.close()
                    return@OnActionSelectedListener true
                }
            }
        })
    }

    private fun getData() {
        mainViewModel.getInfoData(limit = 0, offset = 0)
    }

}