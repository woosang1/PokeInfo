package com.example.pokeinfo.features.detail.common

import androidx.fragment.app.Fragment
import com.example.domain.model.PokemonInfo
import com.example.pokeinfo.features.detail.about.AboutFragment

sealed class Page {
    abstract val pokemonInfo: PokemonInfo
    abstract val title: String
    abstract val fragment: Fragment
    data class About(
        override val pokemonInfo: PokemonInfo,
        override val title : String = "About",
        override val fragment : Fragment = AboutFragment.newInstance(pokemonInfo)
    ) : Page() {
    }

    data class Stats(
        override val pokemonInfo: PokemonInfo,
        override val title : String = "Base Stats",
        override val fragment : Fragment = AboutFragment.newInstance(pokemonInfo)
    ) : Page()

    data class Evolution(
        override val pokemonInfo: PokemonInfo,
        override val title : String = "Evolution",
        override val fragment : Fragment = AboutFragment.newInstance(pokemonInfo)
    ) : Page()

    data class Movies(
        override val pokemonInfo: PokemonInfo,
        override val title : String = "Movies",
        override val fragment : Fragment = AboutFragment.newInstance(pokemonInfo)
    ) : Page()
}