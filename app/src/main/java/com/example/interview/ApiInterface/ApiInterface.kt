package com.example.interview.ApiInterface

import com.example.interview.model.UserResponceModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {


    @GET("/users")
    suspend fun getAllUser():Response<UserResponceModel>
}