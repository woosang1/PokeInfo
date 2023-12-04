package com.example.pokeinfo.features.main.viewModel

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.example.domain.model.PokemonInfo
import com.example.domain.usecase.GetPokemonInfoUseCase
import com.example.pokeinfo.core.base.BaseViewModel
import com.example.pokeinfo.core.ui.bottomSheet.layout.generations.Generation
import com.example.pokeinfo.features.main.common.MainInfoState
import com.example.pokeinfo.features.main.common.MainSideEffect
import com.example.pokeinfo.features.main.common.MainState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import javax.inject.Inject
import org.orbitmvi.orbit.viewmodel.container
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPokemonInfoUseCase: GetPokemonInfoUseCase,
) : BaseViewModel(), ContainerHost<MainState, MainSideEffect> {

    override val container: Container<MainState, MainSideEffect> = container(MainState(MainInfoState.Empty))
    private var pokemonInfo: List<PokemonInfo> = emptyList()

    fun getInfoData(limit: Int?, offset: Int?) = intent {
        if (pokemonInfo.isEmpty()) getInfoDataByServer(limit = limit, offset = offset)
        else {
            viewModelScope.launch {
                reduce {
                    state.copy(mainInfoState = MainInfoState.Info(infoList = pokemonInfo))
                }
            }
        }
    }

    private fun getInfoDataByServer(limit: Int?, offset: Int?) = intent {
        getPokemonInfoUseCase.getInfo(
            limit = limit,
            offset = offset,
            successCallBack = { pokemonInfo ->
                Log.i("logger" , " ${pokemonInfo.toString()}")
                Log.i("logger" , "size :  ${pokemonInfo.size}")
                this@MainViewModel.pokemonInfo = pokemonInfo
                viewModelScope.launch {
                    reduce {
                        state.copy(mainInfoState = MainInfoState.Info(infoList = pokemonInfo))
                    }
                }
            },
            failCallBack = {
                viewModelScope.launch {
                    postAction(MainSideEffect.ShowToast(it))
                    reduce {
                        state.copy(mainInfoState = MainInfoState.Empty)
                    }
                }
            }
        )
    }

    fun getInfoDataWithKeyword(keyword: String) = intent {
        viewModelScope.launch {
            reduce {
                val filterList = pokemonInfo.filter { it.id.contains(keyword) || it.name.contains(keyword) }
                state.copy(mainInfoState = MainInfoState.Info(infoList = filterList))
            }
        }
    }

    fun getInfoDataWithGeneration(generation: Generation) = intent {
        viewModelScope.launch {
            reduce {
                val filterList = pokemonInfo.filter {
                    val index = pokemonInfo.indexOf(it)
                    when (generation.id) {
                        1 -> index in 1..150
                        2 -> index in 151..250
                        3 -> index in 251..385
                        4 -> index in 386..492
                        5 -> index in 493..648
                        6 -> index in 649..720
                        7 -> index in 721..809
                        else -> false
                    }
                }
                state.copy(mainInfoState = MainInfoState.Info(infoList = filterList))
            }
        }
    }

    fun setEmptyState() = intent {
        viewModelScope.launch {
            reduce {
                state.copy(mainInfoState = MainInfoState.Empty)
            }
        }
    }

    fun startDetailActivity(pokemonInfo: PokemonInfo){
        postAction(MainSideEffect.StartDetailActivity(pokemonInfo))
    }

    fun showFavoriteBottomSheet(){
        postAction(MainSideEffect.ShowFavoriteBottomSheet(
            pokemonInfoList = ArrayList<PokemonInfo>()
        ))
    }

    fun showAllTypeBottomSheet(){
        postAction(MainSideEffect.ShowAllTypeBottomSheet(
            pokemonInfoList = ArrayList<PokemonInfo>()
        ))
    }

    fun showGenerationsBottomSheet(){
        postAction(MainSideEffect.ShowGenerationsBottomSheet(
            pokemonInfoList = ArrayList<PokemonInfo>()
        ))
    }

    fun showSearchBottomSheet(){
        postAction(MainSideEffect.ShowSearchBottomSheet)
    }

    fun closeBottomSheet(){
        postAction(MainSideEffect.CloseBottomSheet)
    }

    private fun postAction(sideEffect: MainSideEffect) = intent {
        viewModelScope.launch {
            postSideEffect(sideEffect = sideEffect)
        }
    }

}