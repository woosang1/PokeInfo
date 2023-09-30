package com.example.pokeinfo.features.main.common

sealed class MainSideEffect {
    data class ShowToast(
        val message: String
    ) : MainSideEffect()

    data class StartDetailActivity(
        val id: String
    ) : MainSideEffect()
}