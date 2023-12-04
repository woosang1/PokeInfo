package com.example.pokeinfo.core.ui.bottomSheet.layout.favorite

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.PokemonInfo
import com.example.pokeinfo.core.base.BaseRecyclerAdapter
import com.example.pokeinfo.databinding.LayoutPokemonCardBinding
import com.example.pokeinfo.core.ui.component.viewHolder.PokemonCardViewHolder

class FavoriteAdapter(
    private val favoriteInterface: FavoriteInterface?
) : BaseRecyclerAdapter<PokemonInfo>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonCardViewHolder {
        return PokemonCardViewHolder(binding = LayoutPokemonCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = model.size

    override fun onBindViewHolder(defaultViewHolder: RecyclerView.ViewHolder, position: Int) {
        val pokemonInfo = model[position]
        (defaultViewHolder as? PokemonCardViewHolder)?.bindView(
            pokemonInfo = pokemonInfo,
            clickItem = {
                favoriteInterface?.clickItem(pokemonInfo)
         })
    }
}