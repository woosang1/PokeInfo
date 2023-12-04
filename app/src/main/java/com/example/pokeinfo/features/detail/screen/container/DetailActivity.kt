package com.example.pokeinfo.features.detail.screen.container

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.example.domain.model.PokemonInfo
import com.example.pokeinfo.R
import com.example.pokeinfo.core.base.BaseActivity
import com.example.pokeinfo.databinding.ActivityDetailBinding
import com.example.pokeinfo.features.detail.common.DetailSideEffect
import com.example.pokeinfo.features.detail.common.DetailState
import com.example.pokeinfo.features.detail.common.Page
import com.example.pokeinfo.features.detail.common.UiState
import com.example.pokeinfo.features.detail.screen.viewModel.DetailViewModel
import com.example.pokeinfo.features.detail.screen.adapter.ViewPagerAdapter
import com.example.pokeinfo.utils.intentSerializable
import com.example.pokeinfo.utils.setBackgroundByType
import com.example.pokeinfo.utils.setImageUrl
import com.example.pokeinfo.utils.showToast
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import org.orbitmvi.orbit.viewmodel.observe

@AndroidEntryPoint
class DetailActivity  : BaseActivity<ActivityDetailBinding>() {

    companion object {
        private const val POKE_INFO: String = "pokeInfo"
        fun start(context: Context, pokemonInfo: PokemonInfo){
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
        setData()
        setView()
        setViewPager()
        setTabLayout()
        setListener()
    }

    override fun setObserver() {
        super.setObserver()
        detailViewModel.observe(lifecycleOwner = this, state = ::render, sideEffect = ::handleSideEffect)
    }

    private fun render(state: DetailState) {
        when (state.uiState) {
            is UiState.Init -> {

            }
        }
    }

    private fun handleSideEffect(sideEffect: DetailSideEffect){
        when(sideEffect){
            is DetailSideEffect.ShowToast -> {
                showToast(sideEffect.message)
            }
        }
    }

    private fun setData(){
        detailViewModel.apply {
            pokemonInfo = this@DetailActivity.pokemonInfo
            pokemonInfo?.let {
                pages = ArrayList<Page>().apply {
                    add(Page.About(pokemonInfo = it))
                    add(Page.Stats(pokemonInfo = it))
                    add(Page.Evolution(pokemonInfo = it))
                    add(Page.Movies(pokemonInfo = it))
                }
            }
        }
    }

    private fun setView(){
        pokemonInfo?.let { pokemonInfo ->
            binding.textViewID.text = pokemonInfo.id
            binding.textViewName.text = pokemonInfo.name
            setBackgroundByType(binding.toolbarLayout, pokemonInfo.type)
            binding.imageView.setImageUrl(pokemonInfo.image)
        }
        setFavorite()
    }

    private fun setViewPager(){
        binding.viewPager.apply {
            offscreenPageLimit = 4
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            adapter = ViewPagerAdapter(
                fragmentManager = supportFragmentManager,
                lifecycle = lifecycle,
                pages = detailViewModel.pages
            )
        }
    }
    private fun setTabLayout(){
        //ViewPager, TabLayout 연결
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = detailViewModel.pages[position].title
            // TODO: 여기작업하기.
        }.attach()
        binding.tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    val position = it.position
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                // 탭이 선택 해제됐을 때의 동작
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                // 이미 선택된 탭이 다시 선택됐을 때의 동작
            }
        })
    }

    private fun setListener(){
        binding.favoriteBtn.setOnClickListener {
            detailViewModel.isLike = !detailViewModel.isLike
            detailViewModel.postAction(DetailSideEffect.ShowToast(
                if (detailViewModel.isLike) "저장되었습니다. (좋아요 기능 개발중)"
                else "취소되었습니다."))
            setFavorite()

        }
    }

    private fun setFavorite(){
        if (detailViewModel.isLike) binding.favoriteBtn.setImageResource(R.drawable.favorite_on)
        else binding.favoriteBtn.setImageResource(com.example.pokeinfo.R.drawable.favorite_off)
    }

}
