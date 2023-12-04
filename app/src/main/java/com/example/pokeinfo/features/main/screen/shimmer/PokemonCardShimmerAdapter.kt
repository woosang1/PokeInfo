package com.example.pokeinfo.features.main.screen.shimmer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeinfo.core.base.BaseRecyclerAdapter
import com.example.pokeinfo.databinding.LayoutPokemonCardShimmerBinding

class PokemonCardShimmerAdapter() : BaseRecyclerAdapter<String>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonCardShimmerViewHolder {
        return PokemonCardShimmerViewHolder(
            binding = LayoutPokemonCardShimmerBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(defaultViewHolder: RecyclerView.ViewHolder, position: Int) {
        (defaultViewHolder as? PokemonCardShimmerViewHolder)?.bindView()
    }
    override fun getItemCount(): Int = 8
}