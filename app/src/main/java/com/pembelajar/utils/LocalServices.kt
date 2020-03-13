package com.pembelajar.utils

import com.pembelajar.model.Local
import retrofit2.Call
import retrofit2.http.GET

interface LocalServices {
    @GET("/buaya")
    fun getAll(): Call<Local>
}
