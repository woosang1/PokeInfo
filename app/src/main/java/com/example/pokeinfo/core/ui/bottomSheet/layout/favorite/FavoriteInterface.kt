package com.example.pokeinfo.core.ui.bottomSheet.layout.favorite

import com.example.domain.model.PokemonInfo

interface FavoriteInterface {
    // 카드 클릭.
    fun clickItem(pokemonInfo: PokemonInfo)
}