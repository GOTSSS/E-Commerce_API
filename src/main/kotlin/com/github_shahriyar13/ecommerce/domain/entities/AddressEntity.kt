package com.github_shahriyar13.ecommerce.domain.entities

import jakarta.persistence.*

@Entity
@Table
class AddressEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val street: String,
    val houseNumber: Int?,
    val city: String,
    val state: String,
    val country: String,
    @ManyToOne(fetch = FetchType.LAZY)
    val user: UserEntity
)