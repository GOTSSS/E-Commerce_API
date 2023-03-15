package com.github_shahriyar13.ecommerce.presentation.dtos

data class SignUpRequestDto (
    val mobile: String,
    val password: String,
    val email: String?,
)