package com.example.pokeinfo.features.detail.screen.section.evolution

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.viewpager2.widget.ViewPager2
import com.example.domain.model.PokemonInfo
import com.example.pokeinfo.core.base.BaseFragment
import com.example.pokeinfo.databinding.FragmentAboutBinding
import com.example.pokeinfo.databinding.FragmentEvolutionBinding
import com.example.pokeinfo.features.detail.common.POKE_INFO_KEY
import com.example.pokeinfo.features.detail.screen.section.about.AboutFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EvolutionFragment : BaseFragment<FragmentEvolutionBinding>() {

    companion object {
        fun newInstance(pokemonInfo: PokemonInfo?) : EvolutionFragment = EvolutionFragment().apply {
            arguments = Bundle().apply { putSerializable(POKE_INFO_KEY, pokemonInfo) }
        }
    }

    private val pokeInfo: PokemonInfo? by lazy { arguments?.getSerializable(POKE_INFO_KEY) as PokemonInfo? }

    override fun initBinding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentEvolutionBinding {
        return FragmentEvolutionBinding.inflate(inflater)
    }

    override fun onInitBinding() {
        setRecyclerView()
//        setList()
    }

    private fun setRecyclerView(){
        // TODO: 여기 안나오는 이슈 존재. 
        binding.recyclerView.apply { adapter = EvolutionAdapter(list = pokeInfo?.evolutions) }
    }

//    private fun setList(){
//        Log.i("logger" , "fragment - setList")
//        pokeInfo?.let { pokeInfo ->
//            (binding.recyclerView.adapter as? EvolutionAdapter)?.apply {
////                model.clear()
//                Log.i("logger" , "pokeInfo.evolutions : ${pokeInfo.evolutions}")
//                pokeInfo.evolutions?.let {
//                    Log.i("logger" , "addAll!!")
//                    model.addAll(it)
//                }
//                notifyDataSetChanged()
//            }
//        }
//    }


    override fun setObserver() {
    }
}
