package com.example.pokeinfo.core.ui.bottomSheet.layout.search

interface SearchBottomSheetInterface {
    // 포커스 중일 때 수행할 동작
    fun onFocus()
    // 포커스 해제일 때 수행할 동작

    fun onFocusCleared()

    // 텍스트 변경 시 수행할 동작
    fun onTextChanged(text: CharSequence?)

    // 엔터키 클릭 시 수행할 동작
    fun onEnterKeyPressed()
}