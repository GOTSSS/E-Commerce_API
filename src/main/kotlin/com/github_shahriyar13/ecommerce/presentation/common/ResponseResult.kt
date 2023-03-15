package com.github_shahriyar13.ecommerce.presentation.common

data class ResponseResult<out T>(
    val data: T? = null,
    val code: Int,
    val errorMessage: String? = null,
    val friendlyMessage: String? = null,
)
