package br.com.caiopo.travelbuddy

import android.app.Application

class App : Application() {

    companion object {
        lateinit var instance: App
            private set

        @JvmStatic
        val context by lazy { instance.applicationContext }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
