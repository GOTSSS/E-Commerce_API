package com.github_shahriyar13.ecommerce.domain.entities

import jakarta.persistence.*

@Entity
@Table
data class ProductEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val description: String,
)
