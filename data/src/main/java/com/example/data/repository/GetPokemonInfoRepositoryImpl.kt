package com.example.data.repository

import com.example.domain.model.PokemonInfo
import com.example.data.network.NetworkManager
import com.example.data.model.rp.RpPokemonInfo
import com.example.data.model.rp.mapperToPokemonInfo
import com.example.domain.repository.GetPokemonInfoRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class GetPokemonInfoRepositoryImpl @Inject constructor(
    private val networkManager: NetworkManager
) : GetPokemonInfoRepository {

    override fun getInfo(
        limit: Int?,
        offset: Int?,
        successCallBack: (List<PokemonInfo>) -> Unit,
        failCallBack: (String) -> Unit
    ) {
        networkManager.getPokemonInfo(limit = limit, offset = offset).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : DisposableSingleObserver<RpPokemonInfo>() {
                override fun onSuccess(result: RpPokemonInfo) {
                    val infoList = result.mapperToPokemonInfo()
                    successCallBack.invoke(infoList)
                }

                override fun onError(e: Throwable) {
                    e.message?.let {
                        failCallBack.invoke(it)
                    }
                }
            })
    }
}