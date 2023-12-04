package com.example.pokeinfo.core.ui.bottomSheet.layout.generations

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.pokeinfo.databinding.LayoutGenerationsItemBinding

class GenerationsItemViewHolder(
    private val binding: LayoutGenerationsItemBinding,
) : ViewHolder(binding.root) {

    fun onBind(generation: Generation, clickEvent: () -> Unit){
        binding.textViewTitle.text = itemView.context.getString(generation.title)
        binding.imageView.setImageResource(generation.image)
        binding.rootLayout.setOnClickListener {
            clickEvent.invoke()
        }
    }

}