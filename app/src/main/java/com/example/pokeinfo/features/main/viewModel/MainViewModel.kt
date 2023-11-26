package com.example.pokeinfo.features.main.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.PokemonInfo
import com.example.domain.usecase.GetPokemonInfoUseCase
import com.example.pokeinfo.core.base.BaseViewModel
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

    fun getInfoData(limit: Int?, offset: Int?) = intent {
        getPokemonInfoUseCase.getInfo(
            limit = limit,
            offset = offset,
            successCallBack = { pokemonInfo ->
                Log.i("logger" , " ${pokemonInfo.toString()}")
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

    fun startDetailActivity(pokemonInfo: PokemonInfo){
        postAction(MainSideEffect.StartDetailActivity(pokemonInfo))
    }

    private fun postAction(sideEffect: MainSideEffect) = intent {
        viewModelScope.launch {
            postSideEffect(sideEffect = sideEffect)
        }
    }

}