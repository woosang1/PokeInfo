package com.example.pokeinfo.features.detail

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.domain.model.PokemonInfo
import com.example.pokeinfo.features.detail.common.Page

class ViewPagerAdapter(
    private val fragmentManager: FragmentManager,
    private val context: Context,
    private val pokemonInfo: PokemonInfo
) : FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val pages = ArrayList<Page>()

    init {
        pages.add(Page.About(pokemonInfo = pokemonInfo))
        pages.add(Page.Stats(pokemonInfo = pokemonInfo))
        pages.add(Page.Evolution(pokemonInfo = pokemonInfo))
        pages.add(Page.Movies(pokemonInfo = pokemonInfo))
    }

    override fun getItem(position: Int): Fragment {
        return pages[position].fragment
    }

    override fun getCount(): Int {
        return pages.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return pages[position].title
    }
}
