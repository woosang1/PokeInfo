package com.example.pokeinfo.core.ui.bottomSheet.layout.search

import android.content.Context
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import com.example.pokeinfo.databinding.LayoutSearchBarBinding
import com.example.pokeinfo.utils.focusOn

class SearchBarLayout : FrameLayout {

    private var binding: LayoutSearchBarBinding = LayoutSearchBarBinding.inflate(LayoutInflater.from(context), this, true)

    constructor(context: Context) : super(context) { }
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) { }

    fun getText() : String = binding.editText.text.toString()

    fun setText(word: String){ binding.editText.setText(word) }
    fun setHint(hint: String){ binding.editText.hint = hint }

    fun setOffFocus(){
        binding.editText.apply {
            isFocusable = false
            isFocusableInTouchMode = false
        }
    }

    fun setTextChangedListener(changedListener: TextWatcher) { binding.editText.addTextChangedListener(changedListener) }

    fun focusOff(){
        val isFocused = binding.editText.isFocused
        if (isFocused){
            binding.editText.apply {
                focusOff()
                clearFocus()
            }
        }
    }

    fun focusOn(){
        val isFocused = binding.editText.isFocused
        if (!isFocused) binding.editText.focusOn()
    }

    // 검색 바의 키보드(자판)의 엔터키 입력 처리
    fun setClickEnterListener(enterCallBack: (() -> Unit)? = null) { }

    fun setFocusChangeListener(hasFocusCallback: (() -> Unit) , notFocusCallback : (() -> Unit)){
        binding.editText.setOnFocusChangeListener { v, hasFocus ->
            if (hasFocus){
                hasFocusCallback.invoke()
            }
            else {
                notFocusCallback.invoke()
            }
        }
    }

    fun setClickSearchBarListener(callBack: (() -> Unit)) {
        binding.rootLayout.setOnClickListener {
            callBack.invoke()
        }
    }

    fun setClickCancelListener(callBack: (() -> Unit)) {
        binding.cancelBtn.setOnClickListener {
            callBack.invoke()
        }
    }


}