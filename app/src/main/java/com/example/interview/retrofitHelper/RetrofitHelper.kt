package com.example.interview.retrofitHelper

import com.example.interview.ApiInterface.ApiInterface
import com.example.interview.ApiInterface.LoginApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    val baseUrl = "https://jsonplaceholder.typicode.com"
    val baseUrl1 = "https://api.uzyth.com/"
    var retrofit : Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create())
        .build()
    var service = retrofit.create(ApiInterface::class.java)

    var retrofit1 : Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl1).addConverterFactory(GsonConverterFactory.create())
        .build()
    var service1 = retrofit1.create(LoginApiInterface::class.java)
}