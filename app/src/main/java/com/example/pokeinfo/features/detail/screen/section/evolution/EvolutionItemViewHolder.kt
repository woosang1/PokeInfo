package com.example.pokeinfo.features.detail.screen.section.evolution

import PokemonColorUtil
import android.content.Context
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.domain.model.PokemonInfo
import com.example.pokeinfo.databinding.LayoutEvolutionItemBinding
import com.nolbal.base.view.recyclerview.NBRecyclerAdapter
import com.nolbal.base.view.recyclerview.NBViewHolder

class EvolutionItemViewHolder(
    val context: Context,
    val binding: LayoutEvolutionItemBinding
) : NBViewHolder(binding.root) {

    fun onBind(item: PokemonInfo) {
        Log.i("logger" , "EvolutionItemViewHolder - onBind: ")
        Log.i("logger" , "item : ${item.toString()}")
        with(binding){
            textViewName.text = item.name
            textViewID.text = item.id

            val color = PokemonColorUtil(itemView.context).getPokemonColor(item.typeofpokemon)
            relativeLayoutBackground.background.colorFilter =
                PorterDuffColorFilter(color, PorterDuff.Mode.SRC_ATOP)

            item.typeofpokemon.getOrNull(0).let { firstType ->
                textViewType3.text = firstType
                textViewType3.isVisible = firstType != null
            }

            item.typeofpokemon.getOrNull(1).let { secondType ->
                textViewType2.text = secondType
                textViewType2.isVisible = secondType != null
            }

            item.typeofpokemon.getOrNull(2).let { thirdType ->
                textViewType1.text = thirdType
                textViewType1.isVisible = thirdType != null
            }

            Glide.with(itemView.context)
                .load(item.image)
                .placeholder(android.R.color.transparent)
                .into(imageView)
        }
    }
}