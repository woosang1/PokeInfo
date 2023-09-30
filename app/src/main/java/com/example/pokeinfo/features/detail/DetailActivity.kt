package com.example.pokeinfo.features.detail

import android.content.Context
import android.content.Intent
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.viewModels
import com.example.domain.model.PokemonInfo
import com.example.pokeinfo.core.base.BaseActivity
import com.example.pokeinfo.databinding.ActivityDetailBinding
import com.example.pokeinfo.features.main.MainViewModel
import com.example.pokeinfo.utils.intentSerializable
import com.example.pokeinfo.utils.setBackgroundByType
import com.example.pokeinfo.utils.setImageUrl

class DetailActivity  : BaseActivity<ActivityDetailBinding>() {

    companion object {
        private const val POKE_INFO: String = "pokeInfo"
        fun start(context: Context, pokemonInfo: PokemonInfo){
            Log.d("logger" , "DetailActivity - start")
            Intent(
                context, DetailActivity::class.java
            ).apply {
                putExtra(POKE_INFO, pokemonInfo)
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }.let { intent ->
                context.startActivity(intent)
            }
        }
    }

    private val detailViewModel: DetailViewModel by viewModels()
    private val pokemonInfo: PokemonInfo? by lazy { intent.intentSerializable(POKE_INFO, PokemonInfo::class.java) }

    override fun initBinding(layoutInflater: LayoutInflater): ActivityDetailBinding = ActivityDetailBinding.inflate(layoutInflater)

    override fun onInitBinding() {
        super.onInitBinding()
        setView()
        setViewPager()
    }

    private fun setView(){
        pokemonInfo?.let { pokemonInfo ->
            binding.textViewID.text = pokemonInfo.id
            binding.textViewName.text = pokemonInfo.name
            setBackgroundByType(binding.toolbarLayout, pokemonInfo.type)
            binding.imageView.setImageUrl(pokemonInfo.image)
        }
    }

    private fun setViewPager(){
        binding.viewPager.apply {
            pokemonInfo?.let { it ->
                adapter = ViewPagerAdapter(
                    fragmentManager = this@DetailActivity.supportFragmentManager,
                    context = this@DetailActivity,
                    pokemonInfo = it
                )
            }
        }
    }

}
