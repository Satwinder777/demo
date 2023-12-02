package com.example.interview.model

data class LoginResponce(
    val body: List<Body>,
    val error: Boolean,
    val msg: String
)