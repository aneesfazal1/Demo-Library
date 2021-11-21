package com.example.demoapplication

import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.converter.scalars.ScalarsConverterFactory

import retrofit2.Retrofit


class RetrofitClient private constructor() {
    private val retrofit : Retrofit = Retrofit.Builder().baseUrl(base_url)
        .addConverterFactory(ScalarsConverterFactory.create())
        .addConverterFactory(GsonConverterFactory.create()).build()

    fun getapi(): api { //defining api function
        return retrofit.create(api::class.java)
    }

    companion object {
        //world wide cases
        private const val base_url = "https://api.openweathermap.org/" //base url

        @get:Synchronized
        var instance: RetrofitClient? = null
            get() {
                if (field == null) {
                    field = RetrofitClient()
                }
                return field
            }
            private set
    }
}
