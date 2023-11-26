package com.example.pokeinfo.features.detail.screen.section.state

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.domain.model.PokemonInfo
import com.example.pokeinfo.core.base.BaseFragment
import com.example.pokeinfo.databinding.FragmentStateBinding
import com.example.pokeinfo.features.detail.common.POKE_INFO_KEY
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class StateFragment : BaseFragment<FragmentStateBinding>() {

    companion object {
        fun newInstance(pokemonInfo: PokemonInfo?): StateFragment {
            return StateFragment().apply {
                Log.d("logger", "StateFragment - newInstance : ${pokemonInfo.toString()}")
            arguments = Bundle().apply { putSerializable(POKE_INFO_KEY, pokemonInfo) }
            }
        }
    }

        private val pokeInfo: PokemonInfo? by lazy { arguments?.getSerializable(POKE_INFO_KEY) as PokemonInfo? }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentStateBinding {
        return FragmentStateBinding.inflate(inflater)
    }

    override fun onInitBinding() {
        Log.d("logger", "StateFragment - onInitBinding}")
        pokeInfo?.let { pokeInfo ->
            with(binding){
                textViewTypeDefenses.text = pokeInfo.ydescription

                textViewHP.text = pokeInfo.hp.toString()
                textViewAttack.text = pokeInfo.attack.toString()
                textViewDefense.text = pokeInfo.defense.toString()
                textViewSpAtk.text = pokeInfo.specialAttack.toString()
                textViewSpDef.text = pokeInfo.specialDefense.toString()
                textViewSpeed.text = pokeInfo.speed.toString()
                textViewTotal.text = pokeInfo.total.toString()

                progressBarHP.progress = pokeInfo.hp ?: 0
                progressBarAttack.progress = pokeInfo.attack ?: 0
                progressBarDefense.progress = pokeInfo.defense ?: 0
                progressBarSpAtk.progress = pokeInfo.specialAttack ?: 0
                progressBarSpDef.progress = pokeInfo.specialDefense ?: 0
                progressBarSpeed.progress = pokeInfo.speed ?: 0
                progressBarTotal.progress = pokeInfo.total ?: 0
                executePendingBindings()
            }
        }
    }

    override fun setObserver() {
    }

}
