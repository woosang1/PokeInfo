package com.example.pokeinfo.features.detail.screen.section.moves

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import com.example.domain.model.PokemonInfo
import com.example.pokeinfo.core.base.BaseFragment
import com.example.pokeinfo.databinding.FragmentMoveBinding
import com.example.pokeinfo.features.detail.common.POKE_INFO_KEY
import com.example.pokeinfo.features.detail.screen.section.about.AboutFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MoviesFragment : BaseFragment<FragmentMoveBinding>() {

    companion object {
        fun newInstance(pokemonInfo: PokemonInfo?) : MoviesFragment = MoviesFragment().apply {
            Log.d("logger" , "MoviesFragment - newInstance : ${pokemonInfo.toString()}")
            arguments = Bundle().apply { putSerializable(POKE_INFO_KEY, pokemonInfo) }
        }
    }

    private val pokeInfo: PokemonInfo? by lazy { arguments?.getSerializable(POKE_INFO_KEY) as PokemonInfo? }
    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentMoveBinding {
        return FragmentMoveBinding.inflate(layoutInflater)
    }

    override fun onInitBinding() {
//        pokeInfo?.let { pokeInfo ->
//            with(binding){
//                executePendingBindings()
//            }
//        }
    }

    override fun setObserver() {
    }
}
