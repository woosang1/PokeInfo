package com.example.pokeinfo.features.main

sealed class MainSideEffect {
    data class ShowToast(
        val message: String
    ) : MainSideEffect()
}