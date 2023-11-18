package com.example.pokeinfo.features.detail.screen.viewHolder

import android.util.Log
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.pokeinfo.databinding.DetailPagerLayoutBinding
import com.example.pokeinfo.features.detail.common.Page


class DetailPagerViewHolder(
    private val fragmentManager: FragmentManager,
    private val binding: DetailPagerLayoutBinding
) : ViewHolder(binding.root) {

    fun onBind(page : Page){
        Log.i("logger" , "onBind 호출.")
        Log.i("logger" , "fragmentManager : ${fragmentManager}")
        Log.i("logger" , "fragment : ${page.fragment}")
//        fragmentManager.beginTransaction().replace(binding.rootLayout.id, page.fragment).commitAllowingStateLoss()
        binding.executePendingBindings()
    }

}