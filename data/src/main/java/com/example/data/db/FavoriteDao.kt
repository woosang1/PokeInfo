//package com.example.pokeinfo.core.db
//
//import androidx.room.Dao
//import androidx.room.Insert
//import androidx.room.OnConflictStrategy
//import androidx.room.Query
//
//@Dao
//interface FavoriteDao {
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    suspend fun insert(favoriteData: FavoriteData)
//
//    @Query("DELETE FROM favorite WHERE id = :value")
//    suspend fun clear(value: String)
//
//    @Query("DELETE FROM favorite WHERE id = :id")
//    suspend fun deleteContent(id : String)
//
//}
