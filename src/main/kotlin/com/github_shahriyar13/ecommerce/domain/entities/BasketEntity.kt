package com.github_shahriyar13.ecommerce.domain.entities

import jakarta.persistence.*

@Entity
@Table
data class BasketEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @OneToMany(mappedBy = "basket", cascade = [CascadeType.ALL], orphanRemoval = true)
    val productPurchases: List<ProductPurchaseEntity> = listOf(),
    @ManyToOne(fetch = FetchType.LAZY)
    val user: UserEntity,
)
