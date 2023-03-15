package com.github_shahriyar13.ecommerce.domain.entities.params

data class AddProductToBasketParams(
    val basketId: Long,
    val productId: Long,
    val quantity: Int,
)