//package com.example.pokeinfo.core.db
//
//import android.content.Context
//import androidx.room.Database
//import androidx.room.Room
//import androidx.room.RoomDatabase
//
//@Database(version = 1, entities = [FavoriteData::class], exportSchema = false)
//abstract class FavoriteRoomDataBase : RoomDatabase() {
//    abstract fun favoriteDao(): FavoriteDao
//    companion object {
//        private var instance: FavoriteRoomDataBase? = null
//        @Synchronized
//        fun getInstance(context: Context): FavoriteRoomDataBase {
//            if (instance == null) {
//                instance = Room.databaseBuilder(context,
//                    FavoriteRoomDataBase::class.java, "favorite.db")
//                    .fallbackToDestructiveMigration()
//                    .allowMainThreadQueries()
//                    .build()
//            }
//
//            return instance!!
//        }
//    }
//}
