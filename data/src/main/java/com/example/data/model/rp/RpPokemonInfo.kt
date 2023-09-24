package com.example.data.model.rp

import android.util.Log
import com.example.data.log.LOG_TAG
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
            val id = getPokemonIdFromUrl(result.url)
            add(
                PokemonInfo(
                    number = id.makeNumber(),
//                number = (index+1).makeNumber(),
                    name = result.name ?: "",
                    image = "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/${id}.png"
                )
            )
        }
    }
}

fun getPokemonIdFromUrl(url: String?): Int? {
    Log.d(LOG_TAG, "getPokemonIdFromUrl 호출.")
    Log.d(LOG_TAG, "url : ${url.toString()}")
    Log.d(LOG_TAG, "url.size : ${url?.length}")
    if (url == null) return null
    val indexBySix = findCountSlashIndex(url = url, count = 6)
    val indexBySeven = findCountSlashIndex(url = url, count = 7)
    Log.d(LOG_TAG, "indexBySix : ${indexBySix}")
    Log.d(LOG_TAG, "indexBySeven : ${indexBySeven}")
    indexBySix?.let {
        // URL에서 마지막 '/' 이후의 부분을 추출
        indexBySeven?.let {
            val idString = url.substring(indexBySix + 1, indexBySeven)
            Log.d(LOG_TAG, "idString : ${idString}")
            try {
                // 추출한 문자열을 정수로 변환
                return idString.toInt()
            } catch (e: NumberFormatException) {
                Log.d(LOG_TAG, "e : ${e.toString()}")
                e.printStackTrace()
                return null
            }
        } ?: run { return null }
    } ?: run { return null }
}

fun findCountSlashIndex(url: String, count: Int): Int? {
    var mCount = 0
    for (i in url.indices) {
        if (url[i] == '/') {
            mCount++
            if (mCount == count) {
                return i
            }
        }
    }
    return null
}

fun Int?.makeNumber(): String = String.format("#%03d", this)