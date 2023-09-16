package com.example.domain.repository

import com.example.domain.model.PokemonInfo

interface GetPokemonInfoRepository {
    fun getInfo(limit: Int?, offset: Int?, successCallBack: (List<PokemonInfo>) -> Unit, failCallBack: (String) -> Unit)
}