package com.example.pokeinfo.core.ui.bottomSheet.layout.generations

import android.content.Context
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pokeinfo.R
import com.example.pokeinfo.databinding.LayoutGenerationsBottomSheetBinding
import com.example.pokeinfo.utils.decoration.ItemGridDecorator
import com.example.pokeinfo.utils.dpToPixel

class GenerationsLayout(
    private val context: Context,
    private val generationInterface: GenerationInterface?
) : LinearLayout(context) {

    private var binding: LayoutGenerationsBottomSheetBinding = LayoutGenerationsBottomSheetBinding.inflate(LayoutInflater.from(context), this, true)

    private val generationList : List<Generation> = listOf(
            Generation(id = 1, title = R.string.generation_item_1, image = R.drawable.gen1),
            Generation(id = 2, title = R.string.generation_item_2, image = R.drawable.gen2),
            Generation(id = 3, title = R.string.generation_item_3, image = R.drawable.gen3),
            Generation(id = 4, title = R.string.generation_item_4, image = R.drawable.gen4),
            Generation(id = 5, title = R.string.generation_item_5, image = R.drawable.gen5),
            Generation(id = 6, title = R.string.generation_item_6, image = R.drawable.gen6),
            Generation(id = 7, title = R.string.generation_item_7, image = R.drawable.gen7),
            Generation(id = 8, title = R.string.generation_item_8, image = R.drawable.gen8)
    )

    init {
        setRecyclerView()
        setData()
    }

    private fun setRecyclerView() {
        binding.recyclerView.apply {
            adapter = GenerationsAdapter(generationInterface)
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

    private fun setData(){
        (binding.recyclerView.adapter as? GenerationsAdapter)?.run {
            model.clear()
            addData(ArrayList(generationList))
        }
    }

}