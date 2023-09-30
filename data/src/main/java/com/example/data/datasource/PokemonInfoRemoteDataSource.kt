package com.example.data.datasource

import com.example.data.model.rp.RpPokemonInfo
import com.example.data.network.NetworkManager
import io.reactivex.Single
import javax.inject.Inject

class PokemonInfoRemoteDataSource @Inject constructor(
    private val networkManager: NetworkManager
) {
    fun getInfo() : Single<RpPokemonInfo> = networkManager.getPokemonInfo()
}