package com.example.pokeinfo.features.main.adater

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.PokemonInfo
import com.example.pokeinfo.databinding.LayoutPokemonCardBinding
import com.example.pokeinfo.features.main.viewHolder.PokemonCardViewHolder

class PokemonCardAdapter : RecyclerView.Adapter<PokemonCardViewHolder>() {

    private val model : ArrayList<PokemonInfo> = ArrayList<PokemonInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonCardViewHolder {
        return PokemonCardViewHolder(binding = LayoutPokemonCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = model.size

    override fun onBindViewHolder(holder: PokemonCardViewHolder, position: Int) {
        holder.bindView(model[position])
    }
}