package com.example.pokeinfo.features.main.common

import com.example.domain.model.PokemonInfo

sealed class MainSideEffect {
    data class ShowToast(
        val message: String
    ) : MainSideEffect()

    data class StartDetailActivity(
        val pokemonInfo: PokemonInfo
    ) : MainSideEffect()
}