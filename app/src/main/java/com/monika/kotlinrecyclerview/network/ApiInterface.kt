package com.monika.kotlinrecyclerview.network

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.monika.kotlinrecyclerview.model.ApiResponse
import com.monika.kotlinrecyclerview.model.Facts
import com.monika.kotlinrecyclerview.utils.BASE_URL
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {

    @GET("facts.json")
    fun getFacts(): Observable<ApiResponse<Facts>>

    companion object {
        fun create(): ApiInterface {

            val retrofit = Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()

            return retrofit.create(ApiInterface::class.java)
        }
    }
}