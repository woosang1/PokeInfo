package com.example.pokeinfo.di

import com.example.data.repository.PokemonInfoRepositoryImpl
import com.example.domain.usecase.GetPokemonInfoUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    fun provideGetPokemonInfoUseCase(repository: PokemonInfoRepositoryImpl) = GetPokemonInfoUseCase(repository)

}
