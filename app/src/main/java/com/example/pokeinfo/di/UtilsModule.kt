package com.example.pokeinfo.di

import com.example.data.repository.PokemonInfoRepositoryImpl
import com.example.domain.usecase.GetPokemonInfoUseCase
import com.example.pokeinfo.core.ui.bottomSheet.BottomSheetManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UtilsModule {

//    @Provides
//    fun provideBottomSheetManager() = BottomSheetManager()

}
