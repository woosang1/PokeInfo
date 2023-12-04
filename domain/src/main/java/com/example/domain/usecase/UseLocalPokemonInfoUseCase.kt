package com.example.domain.usecase

import com.example.domain.repository.PokemonInfoRepository
import javax.inject.Inject

class UseLocalPokemonInfoUseCase @Inject constructor(
    private val pokemonInfoRepository: PokemonInfoRepository
){
    fun insertLocalDB() { pokemonInfoRepository.insertLocalDB() }
    fun clearLocalDB() { pokemonInfoRepository.clearLocalDB() }
    fun deleteLocalDB(id: String) { pokemonInfoRepository.deleteLocalDB(id) }

}