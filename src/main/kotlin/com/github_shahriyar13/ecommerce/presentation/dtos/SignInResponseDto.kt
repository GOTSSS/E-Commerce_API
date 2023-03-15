package com.github_shahriyar13.ecommerce.presentation.dtos

import com.github_shahriyar13.ecommerce.domain.entities.UserEntity

data class SignInResponseDto (
    val token: String?,
    val user: UserEntity?
)