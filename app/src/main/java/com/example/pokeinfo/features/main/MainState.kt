package com.example.pokeinfo.features.main

import com.example.domain.model.PokemonInfo

sealed class MainState  {

    data class Info(val infoList: List<PokemonInfo>) : MainState()
    object Empty : MainState()

}