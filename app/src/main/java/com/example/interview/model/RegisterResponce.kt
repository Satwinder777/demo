package com.example.interview.model

data class RegisterResponce(
    val body: List<BodyX>,
    val error: Boolean,
    val msg: String
)