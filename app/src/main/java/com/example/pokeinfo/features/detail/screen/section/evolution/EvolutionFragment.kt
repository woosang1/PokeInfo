package com.example.pokeinfo.features.detail.screen.section.evolution

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.example.domain.model.PokemonInfo
import com.example.pokeinfo.core.base.BaseFragment
import com.example.pokeinfo.databinding.FragmentAboutBinding
import com.example.pokeinfo.databinding.FragmentEvolutionBinding
import com.example.pokeinfo.features.detail.screen.section.about.AboutFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EvolutionFragment : BaseFragment<FragmentEvolutionBinding>() {

    companion object {
        private const val POKE_INFO_KEY: String = "pokeInfo"

        fun newInstance(pokemonInfo: PokemonInfo?) : EvolutionFragment = EvolutionFragment().apply {
            Log.d("logger" , "EvolutionFragment - newInstance : ${pokemonInfo.toString()}")
//            arguments = Bundle().apply { putSerializable(POKE_INFO_KEY, pokemonInfo) }
        }
    }

//    private val dashboardViewModel: DashboardViewModel by viewModel()
    private val pokeInfo: PokemonInfo? by lazy { arguments?.getSerializable(AboutFragment.POKE_INFO_KEY) as PokemonInfo? }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentEvolutionBinding {
        return FragmentEvolutionBinding.inflate(inflater)
    }

    override fun onInitBinding() {
        pokeInfo?.let { pokeInfo ->
            with(binding){
                executePendingBindings()
            }
        }
    }

    override fun setObserver() {
    }
}
