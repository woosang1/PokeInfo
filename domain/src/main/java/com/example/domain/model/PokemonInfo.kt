package com.example.domain.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class PokemonInfo(
    val id: String,
    val name: String,
    val image: String,
    val type: List<String>,
    val abilities: List<String?>,
    val attack: Int,
    val baseExp: String,
    val category: String,
    val cycles: String,
    val defense: Int,
    val eggGroups: String,
    val evolutions: List<PokemonInfo>?,
    val evolvedfrom: String,
    val femalePercentage: String,
    val genderless: Int,
    val height: String,
    val hp: Int,
    val malePercentage: String,
    val reason: String,
    val specialAttack: Int,
    val specialDefense: Int,
    val speed: Int,
    val total: Int,
    val typeofpokemon: List<String>,
    val weaknesses: List<String?>,
    val weight: String,
    val xdescription: String,
    val ydescription: String
): Serializable