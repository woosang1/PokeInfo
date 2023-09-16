package com.example.data.network

import com.example.data.model.rp.RpPokemonInfo
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Provider

class NetworkManager @Inject constructor(
    private val retrofitClient: Provider<RetrofitClient>
) {
    fun getPokemonInfo(
        limit: Int?,
        offset: Int?
    ): Single<RpPokemonInfo> = retrofitClient.get().getVersionRetrofit(NetworkAPI::class.java).getPokemonInfo(
        limit = limit,
        offset = offset
    )

}

