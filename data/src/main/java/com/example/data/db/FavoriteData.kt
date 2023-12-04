//package com.example.pokeinfo.core.db
//
//import androidx.room.Entity
//import androidx.room.Index
//import androidx.room.PrimaryKey
//import com.example.domain.model.PokemonInfo
//
//
//@Entity(tableName = "favorite", indices = [Index(value = ["name"], unique = true)])
//data class FavoriteData(
//    @PrimaryKey(autoGenerate = true)
//    val id: String,
//    val name: String,
//    val image: String,
//    val type: ArrayList<String>,
//    val abilities: ArrayList<String?>,
//    val attack: Int,
//    val baseExp: String,
//    val category: String,
//    val cycles: String,
//    val defense: Int,
//    val eggGroups: String,
//    val evolutions: ArrayList<PokemonInfo>?,
//    val evolvedfrom: String,
//    val femalePercentage: String,
//    val genderless: Int,
//    val height: String,
//    val hp: Int,
//    val malePercentage: String,
//    val reason: String,
//    val specialAttack: Int,
//    val specialDefense: Int,
//    val speed: Int,
//    val total: Int,
//    val typeofpokemon: ArrayList<String>,
//    val weaknesses: ArrayList<String?>,
//    val weight: String,
//    val xdescription: String,
//    val ydescription: String
//)
