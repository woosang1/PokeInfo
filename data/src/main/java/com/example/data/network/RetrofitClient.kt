package com.example.data.network

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {

    companion object {
        const val gistGithubUrl = "https://gist.githubusercontent.com/mrcsxsiq/b94dbe9ab67147b642baa9109ce16e44/raw/97811a5df2df7304b5bc4fbb9ee018a0339b8a38/"
        const val pokeBaseUrl = "https://pokeapi.co/api/v2/"
    }

    fun <S> getRetrofitByGistGithubUrl(service: Class<S>): S =
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(
                RetrofitOkHttpClient.getOkHttpClientBuilder()
            )
            .baseUrl(gistGithubUrl)
            .build()
            .create(service)
}