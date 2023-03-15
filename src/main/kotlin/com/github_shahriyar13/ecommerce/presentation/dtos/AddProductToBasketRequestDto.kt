package com.github_shahriyar13.ecommerce.presentation.dtos

data class AddProductToBasketRequestDto(
    val productId: Long,
    val quantity: Int,
)
