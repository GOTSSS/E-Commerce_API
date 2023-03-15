package com.github_shahriyar13.ecommerce.domain.entities

import jakarta.persistence.*

@Entity
@Table
data class ProductPurchaseEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    val product: ProductEntity,
    val quantity: Int,
    @ManyToOne(fetch = FetchType.LAZY)
    val basket: BasketEntity,
)
