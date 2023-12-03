package com.example.pokeinfo.core.ui.bottomSheet.layout.search

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.widget.LinearLayout
import com.example.pokeinfo.databinding.LayoutSearchBottomSheetBinding

class SearchLayout(
    private val context: Context,
    private val searchBottomSheetInterface: SearchBottomSheetInterface?
) : LinearLayout(context) {

    private var binding: LayoutSearchBottomSheetBinding =
        LayoutSearchBottomSheetBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        binding.searchBar.apply {
            setHint("ex) Charizard or 001")
            // 포커스 변경 시,
            setFocusChangeListener(
                hasFocusCallback = {
                    searchBottomSheetInterface?.onFocus()
                },
                notFocusCallback = {
                    searchBottomSheetInterface?.onFocusCleared()
                }
            )
            // 검색바 클릭 시,
            setClickSearchBarListener { binding.searchBar.focusOn() }
            // 취소 클릭 시,
            setClickCancelListener { binding.searchBar.focusOff() }
            // 텍스트 변경 시,
            setTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
                override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                    searchBottomSheetInterface?.onTextChanged(p0.toString())
                }

                override fun afterTextChanged(p0: Editable?) {}
            })
            // 엔터 키
            setClickEnterListener {
                searchBottomSheetInterface?.onEnterKeyPressed()
                binding.searchBar.focusOff()
            }
        }
    }
}