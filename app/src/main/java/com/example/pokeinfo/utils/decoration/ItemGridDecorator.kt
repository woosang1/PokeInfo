package com.example.pokeinfo.utils.decoration

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemGridDecorator(
    private val spanCount: Int,
    private val topMargin: Int,
    private val bottomMargin: Int,
    private val startMargin: Int,
    private val endMargin: Int,
    private val middleVerticalMargin: Int,
    private val middleHorizontalMargin: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        val layoutParams = view.layoutParams as GridLayoutManager.LayoutParams
        val itemPosition = parent.getChildAdapterPosition(view)

        if (itemPosition == RecyclerView.NO_POSITION) return


        val line = (itemPosition / spanCount) + 1
        val maxLine = ((state.itemCount - 1) / spanCount) + 1

        outRect.run {
            top = if (line == 1) topMargin else (middleVerticalMargin / 2)
            bottom = if (line == maxLine) bottomMargin else (middleVerticalMargin / 2)
            left = if (layoutParams.spanIndex == 0) startMargin else (middleHorizontalMargin / 2)
            right = if (layoutParams.spanIndex == (spanCount - 1)) endMargin else (middleHorizontalMargin / 2)
        }

    }
}