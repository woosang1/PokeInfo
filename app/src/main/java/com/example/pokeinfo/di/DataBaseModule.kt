package com.example.pokeinfo.di

//import android.content.Context
//import com.example.pokeinfo.core.db.FavoriteDao
//import com.example.pokeinfo.core.db.FavoriteRoomDataBase
//import dagger.Module
//import dagger.Provides
//import dagger.hilt.InstallIn
//import dagger.hilt.android.qualifiers.ApplicationContext
//import dagger.hilt.components.SingletonComponent
//import javax.inject.Singleton
//
//@Module
//@InstallIn(SingletonComponent::class)
//object DataBaseModule {
//
//    @Singleton
//    @Provides
//    fun provideFavoriteRoomDataBase(@ApplicationContext context: Context): FavoriteRoomDataBase {
//        return FavoriteRoomDataBase.getInstance(context)
//    }
//    @Provides
//    fun provideRecentlyDao(favoriteRoomDataBase: FavoriteRoomDataBase): FavoriteDao {
//        return favoriteRoomDataBase.favoriteDao()
//    }
//}