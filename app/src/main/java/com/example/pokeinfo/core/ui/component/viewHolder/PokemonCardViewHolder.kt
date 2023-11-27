package com.example.pokeinfo.core.ui.component.viewHolder

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
import com.example.pokeinfo.features.main.viewModel.MainViewModel
import com.example.pokeinfo.utils.dpToPixel

class PokemonCardViewHolder(
    private val binding: LayoutPokemonCardBinding,
) : ViewHolder(binding.root) {

    fun bindView(pokemonInfo: PokemonInfo, clickItem: () -> Unit){
        binding.pokemonInfo = pokemonInfo
        setView(pokemonInfo)
        setClickEvent(clickItem)
        binding.executePendingBindings()
    }

    private fun setView(pokemonInfo: PokemonInfo){
        with(binding){
            setRoundView(this.bgLayout)
            setTextViewByType(textView = this.textViewType3, type = pokemonInfo.type.getOrNull(0))
            setTextViewByType(textView = this.textViewType2, type = pokemonInfo.type.getOrNull(1))
            setTextViewByType(textView = this.textViewType1, type = pokemonInfo.type.getOrNull(2))
        }
    }

    private fun setClickEvent(clickItem: () -> Unit){
        binding.rootLayout.setOnClickListener {
            Log.d("logger" , "rootLayout 클릭")
            clickItem.invoke()
        }
    }

    private fun setRoundView(imageView: ImageView){
        imageView.apply {
            clipToOutline = true
            outlineProvider = object : ViewOutlineProvider() {
                override fun getOutline(view: View, outline: Outline) {
                    outline.setRoundRect(0, 0, view.width, view.height, 8.dpToPixel().toFloat())
                }
            }
        }
    }

    private fun setTextViewByType(textView: TextView, type: String?) {
        textView.text = type
        textView.isVisible = (type != null)
    }

}