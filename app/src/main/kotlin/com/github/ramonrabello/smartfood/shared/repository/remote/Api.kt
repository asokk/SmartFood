package com.github.ramonrabello.smartfood.shared.repository.remote

import com.github.ramonrabello.smartfood.BuildConfig
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Singleton class to return Retrofit instance.
 */
object Api {
    var retrofit:Retrofit = Retrofit.Builder()
            .client(OkHttpClient.Builder()
                    .readTimeout(60000, TimeUnit.MILLISECONDS)
                    .connectTimeout(60000, TimeUnit.MILLISECONDS).build())
            .baseUrl(BuildConfig.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

    fun get(): SmartFoodEndpoint = retrofit.create(SmartFoodEndpoint::class.java)
}