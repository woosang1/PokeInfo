package com.example.pokeinfo.features.main.screen.shimmer

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokeinfo.databinding.LayoutShimmerMainBinding
import com.example.pokeinfo.utils.decoration.ItemGridDecorator
import com.example.pokeinfo.utils.dpToPixel
import com.facebook.shimmer.ShimmerFrameLayout

class MainShimmer : LinearLayout {

    private val binding: LayoutShimmerMainBinding = LayoutShimmerMainBinding.inflate(LayoutInflater.from(context), this, true)

    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        setView(context)
    }

    private fun setView(context: Context) {
        binding.shimmerList.apply {
            layoutManager = GridLayoutManager(context, 2)
            itemAnimator = DefaultItemAnimator()
            adapter = PokemonCardShimmerAdapter()
            while (this.itemDecorationCount > 0) { this.removeItemDecorationAt(0) }
            addItemDecoration(
                ItemGridDecorator(
                    spanCount = 2,
                    topMargin = 0.dpToPixel(),
                    bottomMargin = 0.dpToPixel(),
                    startMargin = 0.dpToPixel(),
                    endMargin = 0.dpToPixel(),
                    middleVerticalMargin = 0.dpToPixel(),
                    middleHorizontalMargin = 0.dpToPixel()
                )
            )
        }
    }

    fun getShimmerLayout() : ShimmerFrameLayout = binding.shimmerLayout

}