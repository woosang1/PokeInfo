package com.example.pokeinfo.features.main.screen.shimmer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeinfo.databinding.LayoutPokemonCardShimmerBinding

class PokemonCardShimmerAdapter() : RecyclerView.Adapter<PokemonCardShimmerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonCardShimmerViewHolder {
        return PokemonCardShimmerViewHolder(
            binding = LayoutPokemonCardShimmerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: PokemonCardShimmerViewHolder, position: Int) {
        holder.bindView()
    }
    override fun getItemCount(): Int = 8
}