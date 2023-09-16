package com.example.pokeinfo.features.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetPokemonInfoUseCase
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
) : ViewModel(), ContainerHost<MainState, MainSideEffect> {

    override val container: Container<MainState, MainSideEffect> = container(MainState.Empty)

    fun getInfoData(limit: Int?, offset: Int?) = intent {
        getPokemonInfoUseCase.getInfo(
            limit = limit,
            offset = offset,
            successCallBack = {
                viewModelScope.launch {
                    reduce {
                        state.run { copy(MainState.Info(infoList = it)) }
                        state
                    }
                }
            },
            failCallBack = {
                viewModelScope.launch {
                    postAction(MainSideEffect.ShowToast(it))
                    reduce {
                        state.run { copy(MainState.Empty) }
                        state
                    }
                }
            }
        )
    }

    private fun postAction(sideEffect: MainSideEffect) = intent {
        viewModelScope.launch {
            postSideEffect(sideEffect = sideEffect)
        }
    }

}