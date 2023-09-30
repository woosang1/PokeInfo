package com.example.data.model.rp

import com.example.domain.model.PokemonInfo
import com.google.gson.annotations.SerializedName

class RpPokemonInfo : ArrayList<RpPokemonInfo.RpPokemon2Item>(){
    data class RpPokemon2Item(
        @SerializedName("abilities")
        val abilities: List<String?>?,
        @SerializedName("attack")
        val attack: Int?,
        @SerializedName("base_exp")
        val baseExp: String?,
        @SerializedName("category")
        val category: String?,
        @SerializedName("cycles")
        val cycles: String?,
        @SerializedName("defense")
        val defense: Int?,
        @SerializedName("egg_groups")
        val eggGroups: String?,
        @SerializedName("evolutions")
        val evolutions: List<String?>?,
        @SerializedName("evolvedfrom")
        val evolvedfrom: String?,
        @SerializedName("female_percentage")
        val femalePercentage: String?,
        @SerializedName("genderless")
        val genderless: Int?,
        @SerializedName("height")
        val height: String?,
        @SerializedName("hp")
        val hp: Int?,
        @SerializedName("id")
        val id: String?,
        @SerializedName("imageurl")
        val imageurl: String?,
        @SerializedName("male_percentage")
        val malePercentage: String?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("reason")
        val reason: String?,
        @SerializedName("special_attack")
        val specialAttack: Int?,
        @SerializedName("special_defense")
        val specialDefense: Int?,
        @SerializedName("speed")
        val speed: Int?,
        @SerializedName("total")
        val total: Int?,
        @SerializedName("typeofpokemon")
        val typeofpokemon: List<String>?,
        @SerializedName("weaknesses")
        val weaknesses: List<String?>?,
        @SerializedName("weight")
        val weight: String?,
        @SerializedName("xdescription")
        val xdescription: String?,
        @SerializedName("ydescription")
        val ydescription: String?
    )
}

fun ArrayList<RpPokemonInfo.RpPokemon2Item>.mapperToPokemonInfo(): List<PokemonInfo> {
    return ArrayList<PokemonInfo>().apply {
        this@mapperToPokemonInfo.forEachIndexed { index, result ->
            add(
                PokemonInfo(
                    id = result.id ?: "",
                    name = result.name ?: "",
                    image = result.imageurl ?: "",
                    type = result.typeofpokemon ?: ArrayList<String>().toList()
                )
            )
        }
    }
}