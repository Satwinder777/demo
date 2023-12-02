package com.example.interview.model

data class Body(
    val IsBuy: Int,
    val _id: Int,
    val active: Int,
    val email: String,
    val first_name: Any,
    val hash_key: String,
    val isAdmin: String,
    val isRedeem: Int,
    val is_kyc_verified: String,
    val is_locked: Int,
    val locked_at: Any,
    val profile_picture: String,
    val promember: String,
    val security_question: String,
    val token: String,
    val two_fa_actived: String,
    val username: String,
    val wrong_login_attempts: Int
)