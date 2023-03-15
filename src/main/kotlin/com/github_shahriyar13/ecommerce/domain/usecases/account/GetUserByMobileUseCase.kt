package com.github_shahriyar13.ecommerce.domain.usecases.account

import com.github_shahriyar13.ecommerce.domain.common.BaseUseCase
import com.github_shahriyar13.ecommerce.domain.entities.UserEntity
import com.github_shahriyar13.ecommerce.infrastructure.jpa.repositories.AccountRepository

class GetUserByMobileUseCase(
    private val accountRepository: AccountRepository
): BaseUseCase<String, UserEntity>() {

    override fun execute(params: String): UserEntity? {
        return accountRepository.getUserEntityByUsername(params)
    }
}