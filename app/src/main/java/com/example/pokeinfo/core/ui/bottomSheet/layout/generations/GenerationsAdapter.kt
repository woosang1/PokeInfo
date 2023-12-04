package com.example.pokeinfo.core.ui.bottomSheet.layout.generations

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeinfo.core.base.BaseRecyclerAdapter
import com.example.pokeinfo.databinding.LayoutGenerationsItemBinding

class GenerationsAdapter(
    private val generationInterface: GenerationInterface?
) : BaseRecyclerAdapter<Generation>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenerationsItemViewHolder {
        return GenerationsItemViewHolder(binding = LayoutGenerationsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),)
    }

    override fun onBindViewHolder(defaultViewHolder: RecyclerView.ViewHolder, position: Int) {
        val generation = model[position]
        (defaultViewHolder as? GenerationsItemViewHolder)?.onBind(
            generation = model[position],
            clickEvent = {
                generationInterface?.clickItem(generation)
            }
        )
    }
}