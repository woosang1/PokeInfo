package com.example.pokeinfo.features.detail.screen.section.about

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
import com.example.pokeinfo.features.detail.common.POKE_INFO_KEY
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AboutFragment : BaseFragment<FragmentAboutBinding>() {

    companion object {
        fun newInstance(pokemonInfo: PokemonInfo?) : AboutFragment = AboutFragment().apply {
            Log.d("logger", "AboutFragment - newInstance : ${pokemonInfo.toString()}")
            arguments = Bundle().apply { putSerializable(POKE_INFO_KEY, pokemonInfo) }
        }
    }

        private val pokeInfo: PokemonInfo? by lazy { arguments?.getSerializable(POKE_INFO_KEY) as PokemonInfo? }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentAboutBinding { return FragmentAboutBinding.inflate(inflater) }

    override fun onInitBinding() {
        Log.d("logger", "AboutFragment - onCreate")
        Log.d("logger", "pokeInfo : ${pokeInfo.toString()}")

        pokeInfo?.let { pokeInfo ->
            Log.d("logger", "pokeInfo?.let { pokeInfo ->")
            with(binding) {
                textViewDescription.text = pokeInfo.name
                textViewHeight.text = pokeInfo.height
                textViewWeight.text = pokeInfo.weight
                textViewEggCycle.text = pokeInfo.cycles
                textViewEggGroups.text = pokeInfo.eggGroups
                textViewBaseEXP.text = pokeInfo.baseExp
                executePendingBindings()
            }
        }
    }

    override fun setObserver() {
    }
}

