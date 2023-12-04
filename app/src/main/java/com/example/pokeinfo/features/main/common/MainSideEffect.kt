package com.example.pokeinfo.features.main.common

import com.example.domain.model.PokemonInfo

sealed class MainSideEffect {
    data class ShowFavoriteBottomSheet(val pokemonInfoList: ArrayList<PokemonInfo>) : MainSideEffect()
    data class ShowAllTypeBottomSheet(val pokemonInfoList: ArrayList<PokemonInfo>) : MainSideEffect()
    data class ShowGenerationsBottomSheet(val pokemonInfoList: ArrayList<PokemonInfo>) : MainSideEffect()
    object ShowSearchBottomSheet: MainSideEffect()
    object CloseBottomSheet: MainSideEffect()
    data class ShowToast(val message: String) : MainSideEffect()
    data class StartDetailActivity(val pokemonInfo: PokemonInfo) : MainSideEffect()
}