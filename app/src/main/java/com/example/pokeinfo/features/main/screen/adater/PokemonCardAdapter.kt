package com.example.pokeinfo.features.main.screen.adater

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.PokemonInfo
import com.example.pokeinfo.core.base.BaseRecyclerAdapter
import com.example.pokeinfo.databinding.LayoutPokemonCardBinding
import com.example.pokeinfo.features.main.viewModel.MainViewModel
import com.example.pokeinfo.core.ui.component.viewHolder.PokemonCardViewHolder

class PokemonCardAdapter(private val mainViewModel: MainViewModel) : BaseRecyclerAdapter<PokemonInfo>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonCardViewHolder {
        return PokemonCardViewHolder(
            binding = LayoutPokemonCardBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int = model.size

    override fun onBindViewHolder(defaultViewHolder: RecyclerView.ViewHolder, position: Int) {
        val pokemonInfo = model[position]
        (defaultViewHolder as? PokemonCardViewHolder)?.bindView(
            pokemonInfo = pokemonInfo,
            clickItem = { mainViewModel.startDetailActivity(pokemonInfo) }
        )
    }
    fun clear() {
        this@PokemonCardAdapter.model.run {
            clear()
            notifyDataSetChanged()
        }
    }


}