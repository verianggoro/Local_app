package com.pembelajar.utils

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object NetworkHelper {
    private var client: OkHttpClient? = null

    private fun getClient() : OkHttpClient{
        if (client == null){
            client = OkHttpClient().newBuilder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .readTimeout(30, TimeUnit.SECONDS)
                .writeTimeout(30, TimeUnit.SECONDS)
                .build()
        }
        return client!!
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://10.0.2.2:5000")
        .client(getClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val services: LocalServices = retrofit.create(LocalServices::class.java)
}