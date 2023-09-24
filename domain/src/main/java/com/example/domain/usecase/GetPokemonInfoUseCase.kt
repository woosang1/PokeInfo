package com.example.domain.usecase

import com.example.domain.model.PokemonInfo
import com.example.domain.repository.GetPokemonInfoRepository
import javax.inject.Inject

class GetPokemonInfoUseCase @Inject constructor(
    private val getPokemonInfoRepository: GetPokemonInfoRepository
){
    fun getInfo(limit: Int?, offset: Int?, successCallBack: (List<PokemonInfo>) -> Unit, failCallBack: (String) -> Unit){
        getPokemonInfoRepository.getInfo(
            limit = limit,
            offset = offset,
            successCallBack = successCallBack,
            failCallBack = failCallBack
        )
    }
}