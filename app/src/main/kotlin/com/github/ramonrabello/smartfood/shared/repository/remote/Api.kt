package com.github.ramonrabello.smartfood.shared.repository.remote

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by ramonrabello on 20/08/17.
 */
object Api {
    val BASE_URL:String = "http://192.168.0.5:8080"
    var retrofit:Retrofit
    init {
        retrofit = Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    fun get(): SmartFoodEndpoint = retrofit.create(SmartFoodEndpoint::class.java)
}