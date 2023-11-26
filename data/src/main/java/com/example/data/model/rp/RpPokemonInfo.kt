package com.example.data.model.rp

import android.util.Log
import com.example.domain.model.PokemonInfo
import com.google.gson.annotations.SerializedName

class RpPokemonInfo : ArrayList<RpPokemonInfo.RpPokemon2Item>(){
    data class RpPokemon2Item(
        @SerializedName("abilities")
        val abilities: List<String?>?,
        @SerializedName("attack")
        val attack: Int?,
        @SerializedName("base_exp")
        val baseExp: String?,
        @SerializedName("category")
        val category: String?,
        @SerializedName("cycles")
        val cycles: String?,
        @SerializedName("defense")
        val defense: Int?,
        @SerializedName("egg_groups")
        val eggGroups: String?,
        @SerializedName("evolutions")
        val evolutions: List<String?>?,
        @SerializedName("evolvedfrom")
        val evolvedfrom: String?,
        @SerializedName("female_percentage")
        val femalePercentage: String?,
        @SerializedName("genderless")
        val genderless: Int?,
        @SerializedName("height")
        val height: String?,
        @SerializedName("hp")
        val hp: Int?,
        @SerializedName("id")
        val id: String?,
        @SerializedName("imageurl")
        val imageurl: String?,
        @SerializedName("male_percentage")
        val malePercentage: String?,
        @SerializedName("name")
        val name: String?,
        @SerializedName("reason")
        val reason: String?,
        @SerializedName("special_attack")
        val specialAttack: Int?,
        @SerializedName("special_defense")
        val specialDefense: Int?,
        @SerializedName("speed")
        val speed: Int?,
        @SerializedName("total")
        val total: Int?,
        @SerializedName("typeofpokemon")
        val typeofpokemon: List<String>?,
        @SerializedName("weaknesses")
        val weaknesses: List<String?>?,
        @SerializedName("weight")
        val weight: String?,
        @SerializedName("xdescription")
        val xdescription: String?,
        @SerializedName("ydescription")
        val ydescription: String?
    )
}

fun ArrayList<RpPokemonInfo.RpPokemon2Item>.mapperToPokemonInfo(): List<PokemonInfo> {
    return ArrayList<PokemonInfo>().apply {
        this@mapperToPokemonInfo.forEachIndexed { index, result ->
            add(
                PokemonInfo(
                    id = result.id ?: "",
                    name = result.name ?: "",
                    image = result.imageurl ?: "",
                    type = result.typeofpokemon ?: ArrayList<String>().toList(),
                    abilities = result.abilities ?: ArrayList<String?>().toList(),
                    attack = result.attack ?: 0,
                    baseExp = result.baseExp ?: "",
                    category = result.category ?: "",
                    cycles = result.cycles ?: "",
                    defense = result.defense ?: 0,
                    eggGroups = result.eggGroups ?: "",
                    evolutions = getPokemonByEvolutionId(result.evolutions),
                    evolvedfrom = result.evolvedfrom ?: "",
                    femalePercentage = result.femalePercentage ?: "",
                    genderless = result.genderless ?: 0,
                    height = result.height ?: "",
                    hp = result.hp ?: 0,
                    malePercentage = result.malePercentage ?: "",
                    reason = result.reason ?: "",
                    specialAttack = result.specialAttack ?: 0,
                    specialDefense = result.specialDefense ?: 0,
                    speed = result.speed ?: 0,
                    total = result.total ?: 0,
                    typeofpokemon = result.typeofpokemon ?: ArrayList<String>().toList(),
                    weaknesses = result.weaknesses ?: ArrayList<String?>().toList(),
                    weight = result.weight ?: "",
                    xdescription = result.xdescription ?: "",
                    ydescription = result.ydescription ?: ""
                )
            )
        }
    }
}

fun ArrayList<RpPokemonInfo.RpPokemon2Item>.getPokemonByEvolutionId(idList : List<String?>?) : List<PokemonInfo> {
    Log.i("logger" , "getPokemonByEvolutionId 호출.")
    val evolutions = ArrayList<PokemonInfo>()
    idList?.forEachIndexed { index, id ->
        val evolutionPokemon = this.firstOrNull { it.id == id }
        Log.i("logger" , "evolutionPokemon : ${evolutionPokemon.toString()}")
        evolutionPokemon?.let { it ->
            evolutions.add(PokemonInfo(
                id = it.id ?: "",
                name = it.name ?: "",
                image = it.imageurl ?: "",
                type = it.typeofpokemon ?: ArrayList<String>().toList(),
                abilities = it.abilities ?: ArrayList<String?>().toList(),
                attack = it.attack ?: 0,
                baseExp = it.baseExp ?: "",
                category = it.category ?: "",
                cycles = it.cycles ?: "",
                defense = it.defense ?: 0,
                eggGroups = it.eggGroups ?: "",
                evolutions = null,
                evolvedfrom = it.evolvedfrom ?: "",
                femalePercentage = it.femalePercentage ?: "",
                genderless = it.genderless ?: 0,
                height = it.height ?: "",
                hp = it.hp ?: 0,
                malePercentage = it.malePercentage ?: "",
                reason = it.reason ?: "",
                specialAttack = it.specialAttack ?: 0,
                specialDefense = it.specialDefense ?: 0,
                speed = it.speed ?: 0,
                total = it.total ?: 0,
                typeofpokemon = it.typeofpokemon ?: ArrayList<String>().toList(),
                weaknesses = it.weaknesses ?: ArrayList<String?>().toList(),
                weight = it.weight ?: "",
                xdescription = it.xdescription ?: "",
                ydescription = it.ydescription ?: ""
            ))
        }
    }
    Log.i("logger" , "evolutions.toList()")
    return evolutions.toList()
}