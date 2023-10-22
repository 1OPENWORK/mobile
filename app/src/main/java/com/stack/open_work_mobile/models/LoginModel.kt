package com.stack.open_work_mobile.models

data class LoginModel(
    val userId: Int,
    val nome: String,
    val email: String,
    val tipo: String,
    val token: String,
    val companyId: Int
)

