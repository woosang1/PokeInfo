package com.example.pokeinfo.features.detail.screen.section.state

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.domain.model.PokemonInfo
import com.example.pokeinfo.core.base.BaseFragment
import com.example.pokeinfo.databinding.FragmentStateBinding
import com.example.pokeinfo.features.detail.screen.section.about.AboutFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StateFragment : BaseFragment<FragmentStateBinding>() {

    companion object {
        private const val POKE_INFO_KEY: String = "pokeInfo"

        fun newInstance(pokemonInfo: PokemonInfo?): StateFragment {
            return StateFragment().apply {
                Log.d("logger", "StateFragment - newInstance : ${pokemonInfo.toString()}")
//            arguments = Bundle().apply { putSerializable(POKE_INFO_KEY, pokemonInfo) }
            }
        }
    }

    //    private val dashboardViewModel: DashboardViewModel by viewModel()
    private val pokeInfo: PokemonInfo? by lazy { arguments?.getSerializable(AboutFragment.POKE_INFO_KEY) as PokemonInfo? }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentStateBinding {
        return FragmentStateBinding.inflate(inflater)
    }

    override fun onInitBinding() {
        Log.d("logger", "StateFragment - onInitBinding}")
//        pokeInfo?.let { pokeInfo ->
//            with(binding){
//                executePendingBindings()
//            }
//        }
    }

    override fun setObserver() {
    }

}
