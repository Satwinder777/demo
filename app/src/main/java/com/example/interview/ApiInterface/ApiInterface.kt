package com.example.interview.ApiInterface

import com.example.interview.model.LoginDetails
import com.example.interview.model.LoginResponce
import com.example.interview.model.RegisterResponce
import com.example.interview.model.UserResponceModel
import com.example.interview.model.rejisterDetails
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {


    @GET("/users")
    suspend fun getAllUser():Response<UserResponceModel>
}
interface LoginApiInterface {


    @POST("/login")
    suspend fun login(@Body login :LoginDetails):Response<LoginResponce>

    @POST("/register")
    suspend fun register(@Body  registerdtl: rejisterDetails) :Response<RegisterResponce>
}
