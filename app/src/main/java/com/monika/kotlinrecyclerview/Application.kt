package com.monika.kotlinrecyclerview

import android.content.Context

class Application : android.app.Application() {

    fun getInstance(context: Context): Application {
        return context.applicationContext as Application
    }

    private var instance: Application? = null

    fun getAppContext(): Application? {
        return instance
    }

    override fun onCreate() {
        super.onCreate()
    }
}