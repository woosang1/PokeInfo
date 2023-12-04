package com.example.pokeinfo.core.ui.bottomSheet.layout.generations

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pokeinfo.core.base.BaseRecyclerAdapter
import com.example.pokeinfo.databinding.LayoutGenerationsItemBinding

class GenerationsAdapter() : BaseRecyclerAdapter<Generation>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenerationsItemViewHolder {
        return GenerationsItemViewHolder(binding = LayoutGenerationsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false),)
    }

    override fun onBindViewHolder(defaultViewHolder: RecyclerView.ViewHolder, position: Int) {
        (defaultViewHolder as? GenerationsItemViewHolder)?.onBind(model[position])
    }
}