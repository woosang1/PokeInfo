package com.example.pokeinfo.features.main.screen.shimmer

import android.graphics.Outline
import android.util.Log
import android.view.View
import android.view.ViewOutlineProvider
import android.widget.ImageView
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.domain.model.PokemonInfo
import com.example.pokeinfo.databinding.LayoutPokemonCardBinding
import com.example.pokeinfo.databinding.LayoutPokemonCardShimmerBinding
import com.example.pokeinfo.features.main.viewModel.MainViewModel
import com.example.pokeinfo.utils.dpToPixel

class PokemonCardShimmerViewHolder(
    private val binding: LayoutPokemonCardShimmerBinding
) : ViewHolder(binding.root) {

    init {
        setRoundView()
    }

    fun bindView(){
        binding.executePendingBindings()
    }

    private fun setRoundView(){
        binding.bgLayout.apply {
            clipToOutline = true
            outlineProvider = object : ViewOutlineProvider() {
                override fun getOutline(view: View, outline: Outline) {
                    outline.setRoundRect(0, 0, view.width, view.height, 8.dpToPixel().toFloat())
                }
            }
        }
    }
}