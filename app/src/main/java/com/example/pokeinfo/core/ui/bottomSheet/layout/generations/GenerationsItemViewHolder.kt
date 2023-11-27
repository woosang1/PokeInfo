package com.example.pokeinfo.core.ui.bottomSheet.layout.generations

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.pokeinfo.databinding.LayoutGenerationsItemBinding

class GenerationsItemViewHolder(
    private val binding: LayoutGenerationsItemBinding,
) : ViewHolder(binding.root) {

    fun onBind(generation: Generation){
        binding.textViewTitle.text = itemView.context.getString(generation.title)
        binding.imageView.setImageResource(generation.image)
        binding.rootLayout.setOnClickListener {
            // TODO: 클릭이벤트 구현 필요.
        }
    }

}