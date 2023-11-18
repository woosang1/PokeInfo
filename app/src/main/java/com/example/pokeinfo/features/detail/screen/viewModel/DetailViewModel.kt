package com.example.pokeinfo.features.detail.screen.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.PokemonInfo
import com.example.domain.usecase.GetPokemonInfoUseCase
import com.example.pokeinfo.features.detail.common.DetailSideEffect
import com.example.pokeinfo.features.detail.common.DetailState
import com.example.pokeinfo.features.detail.common.Page
import com.example.pokeinfo.features.detail.common.UiState
import com.example.pokeinfo.features.detail.screen.container.DetailActivity
import com.example.pokeinfo.features.main.common.MainSideEffect
import com.example.pokeinfo.utils.intentSerializable
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import javax.inject.Inject
import org.orbitmvi.orbit.viewmodel.container
import org.orbitmvi.orbit.syntax.simple.postSideEffect

@HiltViewModel
class DetailViewModel @Inject constructor() : ViewModel(), ContainerHost<DetailState, DetailSideEffect> {

//    private val getPokemonInfoUseCase: GetPokemonInfoUseCase,

    override val container: Container<DetailState, DetailSideEffect> = container(DetailState(uiState = UiState.Init))
    var pokemonInfo: PokemonInfo? = null
    var pages = ArrayList<Page>()

//    fun getInfoData(limit: Int?, offset: Int?) = intent {
//        getPokemonInfoUseCase.getInfo(
//            limit = limit,
//            offset = offset,
//            successCallBack = { pokemonInfo ->
//                Log.d("logger" , "getInfoData - successCallBack")
//                viewModelScope.launch {
//                    reduce {
//                        Log.d("logger", "copy(MainState.Info(infoList = it))")
//                        state.copy(mainInfoState = MainInfoState.Info(infoList = pokemonInfo))
//                    }
//                }
//            },
//            failCallBack = {
//                Log.d("logger" , "getInfoData - failCallBack")
//                viewModelScope.launch {
//                    postAction(MainSideEffect.ShowToast(it))
//                    reduce {
//                        state.copy(mainInfoState = MainInfoState.Empty)
//                    }
//                }
//            }
//        )
//    }
//
//    fun startDetailActivity(id: String){
//        Log.d("logger" , "vm - startDetailActivity ${id}")
//        postAction(MainSideEffect.StartDetailActivity(id))
//    }


    private fun postAction(sideEffect: DetailSideEffect) = intent {
        viewModelScope.launch {
            postSideEffect(sideEffect = sideEffect)
        }
    }

}