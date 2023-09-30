package com.example.pokeinfo.utils

import android.content.Context
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.graphics.Typeface
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.FontRes
import androidx.core.content.res.ResourcesCompat
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import com.example.pokeinfo.R

enum class FontStyle(val type: String){
    BLACK("black"),
    BOLD("bold"),
    BOOK("book"),
    MEDIUM("medium")
}

@BindingAdapter("setFontStyle")
fun setFontStyle(fontTextView: TextView, type: String) {
    when(type){
        FontStyle.BLACK.type -> {
            fontTextView.run {
                setFontBlack()
                textSize = 20F
            }
        }

        FontStyle.BOLD.type -> {
            fontTextView.run {
                setFontBold()
                textSize = 18F
            }
        }

        FontStyle.BOOK.type -> {
            fontTextView.run {
                setFontBook()
                textSize = 14F
            }
        }

        FontStyle.MEDIUM.type -> {
            fontTextView.run {
                setFontMedium()
                textSize = 20F
            }
        }
    }
}

fun TextView.setFontBlack() {
    typeface = context.getFontInAssets(R.font.circularstd_black)
}

fun TextView.setFontBold() {
    typeface = context.getFontInAssets(R.font.circularstd_bold)
}

fun TextView.setFontBook() {
    typeface = context.getFontInAssets(R.font.circularstd_book)
}

fun TextView.setFontMedium() {
    typeface = context.getFontInAssets(R.font.circularstd_medium)
}

fun Context.getFontInAssets(@FontRes resourceId: Int): Typeface? {
    return ResourcesCompat.getFont(this, resourceId)
}