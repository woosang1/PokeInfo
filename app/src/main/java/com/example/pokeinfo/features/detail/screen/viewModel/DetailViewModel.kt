package com.example.pokeinfo.features.detail.screen.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.PokemonInfo
import com.example.pokeinfo.core.base.BaseViewModel
import com.example.pokeinfo.features.detail.common.DetailSideEffect
import com.example.pokeinfo.features.detail.common.DetailState
import com.example.pokeinfo.features.detail.common.Page
import com.example.pokeinfo.features.detail.common.UiState
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

    override val container: Container<DetailState, DetailSideEffect> = container(DetailState(uiState = UiState.Init))
    var pokemonInfo: PokemonInfo? = null
    var pages = ArrayList<Page>()

    fun postAction(sideEffect: DetailSideEffect) = intent {
        viewModelScope.launch {
            postSideEffect(sideEffect = sideEffect)
        }
    }

}