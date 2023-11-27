package com.example.pokeinfo.core.ui.bottomSheet

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import com.example.domain.model.PokemonInfo
import com.example.pokeinfo.core.ui.bottomSheet.layout.allType.AllTypeLayout
import com.example.pokeinfo.core.ui.bottomSheet.layout.favorite.FavoriteLayout
import com.example.pokeinfo.core.ui.bottomSheet.layout.generations.GenerationsLayout
import com.example.pokeinfo.core.ui.bottomSheet.layout.search.SearchLayout
import com.example.pokeinfo.utils.getDeviceHeight
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomSheetManager() : BottomSheetDialogFragment() {

    private var currentType: BottomSheetType = BottomSheetType.FAVORITE
    private var pokemonInfoList : ArrayList<PokemonInfo> = ArrayList<PokemonInfo>()

    constructor(
        currentType: BottomSheetType
    ) : this() {
        this.currentType = currentType
    }

    constructor(
        currentType: BottomSheetType,
        pokemonInfoList : ArrayList<PokemonInfo>,
    ) : this() {
        this.currentType = currentType
        this.pokemonInfoList = pokemonInfoList
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return when(currentType){
            BottomSheetType.FAVORITE -> FavoriteLayout(context = requireContext(), pokemonInfoList = pokemonInfoList)
            BottomSheetType.ALL_TYPE -> AllTypeLayout(context = requireContext())
            BottomSheetType.GENERATIONS -> GenerationsLayout(context = requireContext())
            BottomSheetType.SEARCH -> SearchLayout(context = requireContext())
        }
    }

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() { }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        requireActivity().onBackPressedDispatcher.addCallback(this, onBackPressedCallback)
        val dialog = object : BottomSheetDialog(requireContext()){}
        dialog.behavior.state = BottomSheetBehavior.STATE_COLLAPSED
        dialog.behavior.isDraggable = true
        dialog.behavior.maxHeight = (requireContext().getDeviceHeight() * 0.75).toInt()
        dialog.behavior.peekHeight = (requireContext().getDeviceHeight() * 0.75).toInt()
        return dialog
    }
}
