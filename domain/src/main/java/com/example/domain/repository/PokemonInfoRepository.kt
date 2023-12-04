package com.example.domain.repository

import com.example.domain.model.PokemonInfo

interface PokemonInfoRepository {
    /** remote **/
    fun getInfo(limit: Int?, offset: Int?, successCallBack: (List<PokemonInfo>) -> Unit, failCallBack: (String) -> Unit)

    /** local **/
    fun insertLocalDB()
    fun clearLocalDB()
    fun deleteLocalDB(id: String)
}