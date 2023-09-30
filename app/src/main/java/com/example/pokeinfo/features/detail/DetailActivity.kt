package com.example.pokeinfo.features.detail

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import com.example.pokeinfo.core.base.BaseActivity
import com.example.pokeinfo.databinding.ActivityDetailBinding

class DetailActivity  : BaseActivity<ActivityDetailBinding>() {

    companion object {
        private const val ID: String = "id"
        fun start(context: Context, id: String){
            Log.d("logger" , "DetailActivity - start")
            Intent(
                context, DetailActivity::class.java
            ).apply {
                putExtra(ID, id)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }.let { intent ->
                context.startActivity(intent)
            }
        }
    }

    private val pokemonId: String by lazy { intent.getStringExtra(ID) ?: "" }

    override fun initBinding(layoutInflater: LayoutInflater): ActivityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)

}