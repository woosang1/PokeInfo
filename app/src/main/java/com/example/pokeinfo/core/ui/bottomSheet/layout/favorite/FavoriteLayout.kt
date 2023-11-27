package com.example.pokeinfo.core.ui.bottomSheet.layout.favorite

import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.example.domain.model.PokemonInfo
import com.example.pokeinfo.databinding.LayoutFavoriteBottomSheetBinding
import com.example.pokeinfo.features.main.screen.adater.PokemonCardAdapter
import com.example.pokeinfo.utils.decoration.ItemGridDecorator
import com.example.pokeinfo.utils.dpToPixel

class FavoriteLayout
constructor(context: Context,
            private val pokemonInfoList : ArrayList<PokemonInfo>,
            val closeCallBack : (() -> Unit)? = null) : LinearLayout(context) {

    private var binding: LayoutFavoriteBottomSheetBinding = LayoutFavoriteBottomSheetBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        setRecyclerView()
        addData()
    }

    private fun setRecyclerView() {
        binding.recyclerView.apply {
            adapter = FavoriteAdapter()
            layoutManager = GridLayoutManager(context, 2)
            addItemDecoration(
                ItemGridDecorator(
                    spanCount = 2,
                    topMargin = 0.dpToPixel(),
                    bottomMargin = 0.dpToPixel(),
                    startMargin = 0.dpToPixel(),
                    endMargin = 0.dpToPixel(),
                    middleVerticalMargin = 8.dpToPixel(),
                    middleHorizontalMargin = 8.dpToPixel()
                )
            )
        }
    }

    private fun addData(){
        (binding.recyclerView.adapter as? FavoriteAdapter)?.addData(pokemonInfoList)
    }

}