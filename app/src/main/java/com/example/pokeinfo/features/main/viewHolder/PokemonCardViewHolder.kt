package com.example.pokeinfo.features.main.viewHolder

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.domain.model.PokemonInfo
import com.example.pokeinfo.databinding.LayoutPokemonCardBinding

class PokemonCardViewHolder(
    val binding: LayoutPokemonCardBinding
) : ViewHolder(binding.root) {

    fun bindView(pokemonInfo: PokemonInfo){
        binding.pokemonInfo = pokemonInfo
        binding.executePendingBindings()
    }

}