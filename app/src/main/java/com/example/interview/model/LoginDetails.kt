package com.example.interview.model

data class LoginDetails(
    val device_type: String,
    val email: String,
    val fcm_token: String,
    val password: String
)