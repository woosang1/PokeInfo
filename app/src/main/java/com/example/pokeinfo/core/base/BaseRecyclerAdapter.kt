package com.example.pokeinfo.core.base

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import kotlin.collections.ArrayList

abstract class BaseRecyclerAdapter<M> : RecyclerView.Adapter<ViewHolder>() {

    var model: ArrayList<M> = ArrayList()
    
    abstract override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    override fun onBindViewHolder(defaultViewHolder: ViewHolder, position: Int) { }

    override fun getItemCount(): Int = model.size
    
    open fun addData(modelArrayList: ArrayList<M>?) {
        model.addAll(modelArrayList!!)
        notifyDataSetChanged()
    }


}
