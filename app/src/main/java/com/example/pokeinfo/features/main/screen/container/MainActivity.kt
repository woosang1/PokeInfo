package com.example.pokeinfo.features.main.screen.container

import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.domain.model.PokemonInfo
import com.example.pokeinfo.R
import com.example.pokeinfo.core.base.BaseActivity
import com.example.pokeinfo.core.ui.bottomSheet.BottomSheetManager
import com.example.pokeinfo.core.ui.bottomSheet.BottomSheetType
import com.example.pokeinfo.core.ui.bottomSheet.layout.favorite.FavoriteInterface
import com.example.pokeinfo.core.ui.bottomSheet.layout.generations.Generation
import com.example.pokeinfo.core.ui.bottomSheet.layout.generations.GenerationInterface
import com.example.pokeinfo.core.ui.bottomSheet.layout.search.SearchBottomSheetInterface
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
import com.example.pokeinfo.utils.checkFolderPhone
import com.example.pokeinfo.utils.startShimmer
import com.example.pokeinfo.utils.stopShimmerLayout

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private val mainViewModel: MainViewModel by viewModels()
    private var bottomSheet : BottomSheetManager? = null

    override fun initBinding(layoutInflater: LayoutInflater): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)
    override fun onInitBinding() { checkFolderPhone() }

    private fun checkFolderPhone() {
        checkFolderPhone(
            lifecycleOwner = this,
            lifecycle = lifecycle,
            doubleScreenModeCallBack = {
                // 폴더폰 시,
                setRecyclerView()
                setSpeedDialView()
                getData()
            },
            singleScreenModeCallback = {
                // 일반폰 or 폴더폰(접음)시,
                setRecyclerView()
                setSpeedDialView()
                getData()
            }
        )
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
        when (state.mainInfoState) {
            is MainInfoState.Info -> {
                (binding.recyclerView.adapter as? PokemonCardAdapter)?.run {
                    model.clear()
                    addData(ArrayList(state.mainInfoState.infoList))
                }
                stopShimmerLayout(shimmerLayout = binding.shimmerLayout.getShimmerLayout(), contentLayout = binding.recyclerView)
            }

            is MainInfoState.Empty -> {
                (binding.recyclerView.adapter as? PokemonCardAdapter)?.clear()
                startShimmer(shimmerLayout = binding.shimmerLayout.getShimmerLayout(), contentLayout = binding.recyclerView)
            }
        }
    }

    private fun handleSideEffect(mainSideEffect: MainSideEffect) {
        when (mainSideEffect) {
            // TODO: 좋아요 포켓몬 -> local DB로 변경 필요.
            is MainSideEffect.ShowFavoriteBottomSheet -> {
                bottomSheet = BottomSheetManager(
                    currentType = BottomSheetType.FAVORITE,
                    pokemonInfoList = (binding.recyclerView.adapter as? PokemonCardAdapter)?.model?.filter { it.type.any { it.contains("Fire") } }?.let { ArrayList(it) } ?: ArrayList<PokemonInfo>(),
                    favoriteInterface = object : FavoriteInterface {
                        override fun clickItem(pokemonInfo: PokemonInfo) {
                            mainViewModel.startDetailActivity(pokemonInfo)
                            mainViewModel.closeBottomSheet()
                        }
                    }
                )
                bottomSheet?.let { it.show(supportFragmentManager, it.tag) }
            }

            is MainSideEffect.ShowAllTypeBottomSheet -> {
                bottomSheet = BottomSheetManager(BottomSheetType.ALL_TYPE)
                bottomSheet?.let { it.show(supportFragmentManager, it.tag) }
            }

            is MainSideEffect.ShowGenerationsBottomSheet -> {
                bottomSheet = BottomSheetManager(
                    currentType = BottomSheetType.GENERATIONS,
                    generationInterface = object : GenerationInterface {
                        override fun clickItem(generation: Generation) {
                            mainViewModel.run {
                                setEmptyState()
                                getInfoDataWithGeneration(generation)
                                closeBottomSheet()
                            }
                        }
                    }
                )
                bottomSheet?.let { it.show(supportFragmentManager, it.tag) }
            }

            is MainSideEffect.ShowSearchBottomSheet -> {
                bottomSheet = BottomSheetManager(
                    currentType = BottomSheetType.SEARCH,
                    searchBottomSheetInterface = object : SearchBottomSheetInterface {
                        override fun onFocus() { }
                        override fun onFocusCleared() { }
                        override fun onTextChanged(text: CharSequence?) {
                            val value = text.toString()
                            mainViewModel.setEmptyState()
                            if (value.isNotEmpty()) mainViewModel.getInfoDataWithKeyword(value)
                            else mainViewModel.getInfoData(limit = 0, offset = 0)
                        }
                        override fun onEnterKeyPressed() {
                            mainViewModel.closeBottomSheet()
                        }
                    }
                )
                bottomSheet?.let { it.show(supportFragmentManager, it.tag) }
            }

            is MainSideEffect.ShowToast -> {
                showToast(mainSideEffect.message)
            }

            is MainSideEffect.StartDetailActivity -> {
                DetailActivity.start(this@MainActivity, mainSideEffect.pokemonInfo)
            }

            is MainSideEffect.CloseBottomSheet -> {
                bottomSheet?.dismiss()
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