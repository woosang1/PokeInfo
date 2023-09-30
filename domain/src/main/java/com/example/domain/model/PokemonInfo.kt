package com.example.domain.model

data class PokemonInfo(
    val id: String,
    val name: String,
    val image: String,
    val type: List<String>
)