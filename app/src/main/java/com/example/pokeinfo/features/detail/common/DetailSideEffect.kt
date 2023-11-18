package com.example.pokeinfo.features.detail.common


sealed class DetailSideEffect {

    data class ShowToast(
        val message: String
    ) : DetailSideEffect()
}