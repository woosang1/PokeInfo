package com.example.pokeinfo.features.detail.screen.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.lifecycle.Lifecycle
import com.example.pokeinfo.features.detail.common.Page

class ViewPagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle, private val pages : ArrayList<Page>)
    : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int = pages.size
    override fun createFragment(position: Int): Fragment = pages[position].fragment
}
