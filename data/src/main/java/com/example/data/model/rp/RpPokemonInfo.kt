package com.example.data.model.rp

import com.example.domain.model.PokemonInfo
import com.google.gson.annotations.SerializedName

data class RpPokemonInfo(
    @SerializedName("count")
    val count: Int?,
    @SerializedName("next")
    val next: String?,
    @SerializedName("previous")
    val previous: Any?,
    @SerializedName("results")
    val results: List<Result>?
) {
    data class Result(
        @SerializedName("name")
        val name: String?,
        @SerializedName("url")
        val url: String?
    )
}

fun RpPokemonInfo.mapperToPokemonInfo(): List<PokemonInfo> {
    return ArrayList<PokemonInfo>().apply {
        this@mapperToPokemonInfo.results?.forEachIndexed { index, result ->
            add(PokemonInfo(
                name = result.name ?: "",
                image = result.url ?: ""
            ))
        }
    }
}