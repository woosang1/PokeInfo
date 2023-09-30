package com.example.domain.usecase

import com.example.domain.model.PokemonInfo
import com.example.domain.repository.PokemonInfoRepository
import javax.inject.Inject

class GetPokemonInfoUseCase @Inject constructor(
    private val pokemonInfoRepository: PokemonInfoRepository
){
    fun getInfo(limit: Int?, offset: Int?, successCallBack: (List<PokemonInfo>) -> Unit, failCallBack: (String) -> Unit){
        pokemonInfoRepository.getInfo(
            limit = limit,
            offset = offset,
            successCallBack = successCallBack,
            failCallBack = failCallBack
        )
    }
}