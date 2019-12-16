package com.monika.kotlinrecyclerview.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.monika.kotlinrecyclerview.model.ApiResponse
import com.monika.kotlinrecyclerview.model.Facts
import com.monika.kotlinrecyclerview.network.ApiInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class FactsListViewModel(application: Application) : BaseViewModel(application) {

    private var disposable: Disposable? = null
    val factsListData by lazy { MutableLiveData<ApiResponse<Facts>>() }

    private val wikiApiServe by lazy {
        ApiInterface.create()
    }

    fun fetchFacts(): MutableLiveData<ApiResponse<Facts>>{
        disposable = wikiApiServe.getFacts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ reportResponse ->
                factsListData.setValue(reportResponse)
            })
        return factsListData
    }
}