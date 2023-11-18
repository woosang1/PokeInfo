package com.example.pokeinfo.features.detail.common

data class DetailState(
    val uiState: UiState
)

sealed class UiState {
    object Init : UiState()
}
