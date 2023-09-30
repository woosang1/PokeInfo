package com.example.pokeinfo.features.detail.about

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.RequiresApi
import com.example.domain.model.PokemonInfo
import com.example.pokeinfo.core.base.BaseFragment
import com.example.pokeinfo.databinding.FragmentAboutBinding

class AboutFragment : BaseFragment<FragmentAboutBinding>() {

    companion object {
        private const val POKE_INFO_KEY: String = "pokeInfo"

        @JvmStatic
        fun newInstance(pokemonInfo: PokemonInfo?) = AboutFragment().apply {
            Log.d("logger" , "AboutFragment - newInstance : ${pokemonInfo.toString()}")
            arguments = Bundle().apply { putSerializable(POKE_INFO_KEY, pokemonInfo) }
        }
    }

//    private val dashboardViewModel: DashboardViewModel by viewModel()
    private var pokeInfo: PokemonInfo? = null

    override fun initBinding(layoutInflater: LayoutInflater): FragmentAboutBinding = FragmentAboutBinding.inflate(layoutInflater)

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("logger" , "AboutFragment - onCreate")
        pokeInfo = savedInstanceState?.getSerializable(POKE_INFO_KEY, PokemonInfo::class.java)

        Log.d("logger" , "pokeInfo : ${pokeInfo.toString()}")

        pokeInfo?.let { pokeInfo ->
            Log.d("logger" , "pokeInfo?.let { pokeInfo ->")
            with(binding){
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}
