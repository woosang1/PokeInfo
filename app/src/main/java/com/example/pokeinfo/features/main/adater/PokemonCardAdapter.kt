package com.example.pokeinfo.features.main.adater

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.PokemonInfo
import com.example.pokeinfo.databinding.LayoutPokemonCardBinding
import com.example.pokeinfo.features.main.MainViewModel
import com.example.pokeinfo.features.main.viewHolder.PokemonCardViewHolder

class PokemonCardAdapter(private val mainViewModel: MainViewModel) : RecyclerView.Adapter<PokemonCardViewHolder>() {

    private val model : ArrayList<PokemonInfo> = ArrayList<PokemonInfo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonCardViewHolder {
        return PokemonCardViewHolder(
            binding = LayoutPokemonCardBinding.inflate(LayoutInflater.from(parent.context), parent, false),
            mainViewModel = mainViewModel
        )
    }

    override fun getItemCount(): Int = model.size

    override fun onBindViewHolder(holder: PokemonCardViewHolder, position: Int) {
        holder.bindView(model[position])
    }

    fun addData(model : List<PokemonInfo>){
        Log.d("logger" , "PokemonCardAdapter - addData")
        Log.d("logger" , "model : ${model.toString()}")
        this@PokemonCardAdapter.model.run {
            clear()
            addAll(model)
            notifyDataSetChanged()
        }
    }

}