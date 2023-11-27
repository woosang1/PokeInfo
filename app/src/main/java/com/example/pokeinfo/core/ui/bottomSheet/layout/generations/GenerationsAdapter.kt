package com.example.pokeinfo.core.ui.bottomSheet.layout.generations

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.PokemonInfo
import com.example.pokeinfo.databinding.LayoutGenerationsItemBinding
import com.example.pokeinfo.databinding.LayoutPokemonCardBinding
import com.example.pokeinfo.features.main.viewModel.MainViewModel
import com.example.pokeinfo.features.main.screen.viewHolder.PokemonCardViewHolder

class GenerationsAdapter() : RecyclerView.Adapter<GenerationsItemViewHolder>() {

    private val model : ArrayList<Generation> = ArrayList<Generation>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenerationsItemViewHolder {
        return GenerationsItemViewHolder(binding = LayoutGenerationsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),)
    }

    override fun getItemCount(): Int = model.size

    override fun onBindViewHolder(holder: GenerationsItemViewHolder, position: Int) {
        holder.onBind(model[position])
    }

    fun setData(list: List<Generation>){
        model.clear()
        model.addAll(list)
    }

}