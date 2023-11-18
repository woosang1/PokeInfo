package com.example.pokeinfo.features.detail.evolution

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.RequiresApi
import com.example.domain.model.PokemonInfo
import com.example.pokeinfo.core.base.BaseFragment
import com.example.pokeinfo.databinding.FragmentAboutBinding
import com.example.pokeinfo.databinding.FragmentEvolutionBinding
import com.example.pokeinfo.features.detail.about.AboutFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EvolutionFragment : BaseFragment<FragmentEvolutionBinding>() {

    companion object {
        private const val POKE_INFO_KEY: String = "pokeInfo"

        @JvmStatic
        fun newInstance(pokemonInfo: PokemonInfo?) = EvolutionFragment().apply {
            Log.d("logger" , "AboutFragment - newInstance : ${pokemonInfo.toString()}")
            arguments = Bundle().apply { putSerializable(POKE_INFO_KEY, pokemonInfo) }
        }
    }

//    private val dashboardViewModel: DashboardViewModel by viewModel()
    private val pokeInfo: PokemonInfo? by lazy { arguments?.getSerializable(AboutFragment.POKE_INFO_KEY) as PokemonInfo? }

    override fun initBinding(layoutInflater: LayoutInflater): FragmentEvolutionBinding = FragmentEvolutionBinding.inflate(layoutInflater)

    override fun onInitBinding() {
        super.onInitBinding()
        pokeInfo?.let { pokeInfo ->
            with(binding){
                executePendingBindings()
            }
        }
    }
}
