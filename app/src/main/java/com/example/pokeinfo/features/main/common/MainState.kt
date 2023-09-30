package com.example.pokeinfo.features.main.common

import com.example.domain.model.PokemonInfo

data class MainState(
    val mainInfoState: MainInfoState
)

sealed class MainInfoState {
    data class Info(val infoList: List<PokemonInfo>) : MainInfoState()
    object Empty : MainInfoState()
}
