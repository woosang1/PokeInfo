package com.example.pokeinfo.features.main

import androidx.lifecycle.ViewModel
import com.example.data.repository.GetPokemonInfoRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getPokemonInfoRepository: GetPokemonInfoRepositoryImpl
) : ViewModel() {

    fun getPokemonInfoRepository(limit: Int?, offset: Int?){
        getPokemonInfoRepository.getInfo(
            limit = limit,
            offset = offset,
            successCallBack = {},
            failCallBack =  {}
        )
    }

}