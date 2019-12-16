package com.monika.kotlinrecyclerview

import io.realm.Realm

class Application : android.app.Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this) //init realmdb this covers all use of realm within the project.
    }
}