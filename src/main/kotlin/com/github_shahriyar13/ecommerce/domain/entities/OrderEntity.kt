package com.github_shahriyar13.ecommerce.domain.entities

import jakarta.persistence.*

@Entity
@Table
data class OrderEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @OneToOne(fetch = FetchType.LAZY)
    val basket: BasketEntity,
    @ManyToOne(fetch = FetchType.LAZY)
    val user: UserEntity,
)
