package com.monika.kotlinrecyclerview.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import io.reactivex.disposables.CompositeDisposable
import io.realm.Realm

open class BaseViewModel protected constructor(application: Application) :
    AndroidViewModel(application) {

    private val disposable = CompositeDisposable()
    private val realm = Realm.getDefaultInstance()

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
        if (!realm.isClosed) realm.close()
    }

}