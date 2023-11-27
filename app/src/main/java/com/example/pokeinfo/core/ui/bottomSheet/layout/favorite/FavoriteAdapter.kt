package com.example.pokeinfo.core.ui.bottomSheet.layout.favorite

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.PokemonInfo
import com.example.pokeinfo.databinding.LayoutPokemonCardBinding
import com.example.pokeinfo.core.ui.component.viewHolder.PokemonCardViewHolder

class FavoriteAdapter() : RecyclerView.Adapter<PokemonCardViewHolder>() {

    private val model : ArrayList<PokemonInfo> = ArrayList<PokemonInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonCardViewHolder {
        return PokemonCardViewHolder(binding = LayoutPokemonCardBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = model.size

    override fun onBindViewHolder(holder: PokemonCardViewHolder, position: Int) {
        val pokemonInfo = model[position]
        holder.bindView(
            pokemonInfo = pokemonInfo,
            clickItem = { // TODO: 클릭이벤트 구현하기.
         })
    }

    fun addData(model : List<PokemonInfo>){
        this@FavoriteAdapter.model.run {
            clear()
            addAll(model)
            notifyDataSetChanged()
        }
    }

}