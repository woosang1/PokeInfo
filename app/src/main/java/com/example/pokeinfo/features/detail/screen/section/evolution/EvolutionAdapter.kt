package com.example.pokeinfo.features.detail.screen.section.evolution

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.domain.model.PokemonInfo
import com.example.pokeinfo.databinding.LayoutEvolutionItemBinding
import com.nolbal.base.view.recyclerview.NBRecyclerAdapter
import com.nolbal.base.view.recyclerview.NBViewHolder

class EvolutionAdapter(
    private val list : List<PokemonInfo>?
) : NBRecyclerAdapter<PokemonInfo>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NBViewHolder {
        return EvolutionItemViewHolder(
            context = parent.context,
            binding = LayoutEvolutionItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(defaultViewHolder: NBViewHolder, position: Int) {
        super.onBindViewHolder(defaultViewHolder, position)
        Log.i("logger" , "EvolutionAdapter - onBindViewHolder [${position}]")
        (defaultViewHolder as? EvolutionItemViewHolder)?.onBind(item = model[position])
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }
}
