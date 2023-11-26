package com.example.pokeinfo.features.detail.common

import androidx.fragment.app.Fragment
import com.example.domain.model.PokemonInfo
import com.example.pokeinfo.features.detail.screen.section.about.AboutFragment
import com.example.pokeinfo.features.detail.screen.section.evolution.EvolutionFragment
import com.example.pokeinfo.features.detail.screen.section.moves.MoviesFragment
import com.example.pokeinfo.features.detail.screen.section.state.StateFragment

const val POKE_INFO_KEY: String = "pokeInfo"

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
        override val fragment : Fragment = StateFragment.newInstance(pokemonInfo)
    ) : Page()

    data class Evolution(
        override val pokemonInfo: PokemonInfo,
        override val title : String = "Evolution",
        override val fragment : Fragment = EvolutionFragment.newInstance(pokemonInfo)
    ) : Page()

    data class Movies(
        override val pokemonInfo: PokemonInfo,
        override val title : String = "Movies",
        override val fragment : Fragment = MoviesFragment.newInstance(pokemonInfo)
    ) : Page()
}