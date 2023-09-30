package com.example.data.network

import com.example.data.model.rp.RpPokemonInfo
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Provider

class NetworkManager @Inject constructor(
    private val retrofitClient: Provider<RetrofitClient>
) {
    fun getPokemonInfo(): Single<RpPokemonInfo> = retrofitClient.get().getRetrofitByGistGithubUrl(NetworkAPI::class.java).getPokemonInfo()

}

