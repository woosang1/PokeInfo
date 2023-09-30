package com.example.pokeinfo.features.main

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetPokemonInfoUseCase
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
) : ViewModel(), ContainerHost<MainState, MainSideEffect> {

    override val container: Container<MainState, MainSideEffect> = container(MainState(MainInfoState.Empty))

    fun getInfoData(limit: Int?, offset: Int?) = intent {
        getPokemonInfoUseCase.getInfo(
            limit = limit,
            offset = offset,
            successCallBack = { pokemonInfo ->
                Log.d("logger" , "getInfoData - successCallBack")
                viewModelScope.launch {
                    reduce {
                        Log.d("logger", "copy(MainState.Info(infoList = it))")
                        state.copy(mainInfoState = MainInfoState.Info(infoList = pokemonInfo))
                    }
                }
            },
            failCallBack = {
                Log.d("logger" , "getInfoData - failCallBack")
                viewModelScope.launch {
                    postAction(MainSideEffect.ShowToast(it))
                    reduce {
                        state.copy(mainInfoState = MainInfoState.Empty)
                    }
                }
            }
        )
    }

    fun startDetailActivity(id: String){
        Log.d("logger" , "vm - startDetailActivity ${id}")
        postAction(MainSideEffect.StartDetailActivity(id))
    }


    private fun postAction(sideEffect: MainSideEffect) = intent {
        viewModelScope.launch {
            postSideEffect(sideEffect = sideEffect)
        }
    }

}