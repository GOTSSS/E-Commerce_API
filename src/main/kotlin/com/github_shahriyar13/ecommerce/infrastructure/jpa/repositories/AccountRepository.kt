package com.github_shahriyar13.ecommerce.infrastructure.jpa.repositories

import com.github_shahriyar13.ecommerce.domain.entities.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository: UserDetailsService, JpaRepository<UserEntity, Long> {

    fun getUserEntityByUsername(username: String): UserEntity?

    override fun loadUserByUsername(username: String): UserEntity? = getUserEntityByUsername(username)
}