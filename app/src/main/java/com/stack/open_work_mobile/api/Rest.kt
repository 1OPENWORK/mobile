package com.stack.open_work_mobile.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Rest {
    fun getInstance(): Retrofit? {
        return Retrofit
            .Builder()
            .baseUrl("http://52.21.11.236:8080/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}