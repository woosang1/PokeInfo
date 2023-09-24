package com.example.data.network

import com.example.data.model.rp.RpPokemonInfo
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface NetworkAPI {

    /**
     * 포켓몬 조회
     */
    @GET("pokemon/")
    fun getPokemonInfo(
        @Query("limit") limit: Int?,
        @Query("offset") offset: Int?,
    ): Single<RpPokemonInfo>

    /**
     * 포켓몬 상세 정보
     */
    @GET("pokemon/")
    fun getPokemonDetailInfo(
        @Query("id") id: Int?,
        @Query("name") name: String?,
    ): Single<RpPokemonInfo>


//    /**
//     * 모든 시장 현황 상세 정보
//     */
//    @GET("ticker/detailed/all")
//    fun getDetailAll(
//    ): Single<RpDetailAllModel>
//
//    /**
//     * 해당 코인 상세 정보
//     */
//    @GET("ticker/detailed")
//    fun getDetail(
//        @Query("title") currencyPair: String,
//    ): Single<RpDetailModel>
}
