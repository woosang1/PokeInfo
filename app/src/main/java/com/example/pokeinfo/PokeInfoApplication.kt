package com.example.pokeinfo

import android.app.Application
import android.content.Context

class PokeInfoApplication : Application() {

    companion object {
        private lateinit var instance: PokeInfoApplication

        private fun setInstance(application: PokeInfoApplication) {
            instance = application
        }

        fun getGlobalContext(): Context = instance.applicationContext
    }

    override fun onCreate() {
        super.onCreate()
        setInstance(this@PokeInfoApplication)
    }
}