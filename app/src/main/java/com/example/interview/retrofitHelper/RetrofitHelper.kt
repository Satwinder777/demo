package com.example.interview.retrofitHelper

import com.example.interview.ApiInterface.ApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    val baseUrl = "https://jsonplaceholder.typicode.com"
    var retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
        .build()
    var service = retrofit.create(ApiInterface::class.java)
}