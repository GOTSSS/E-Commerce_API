package com.github_shahriyar13.ecommerce.domain.usecases.account

import com.github_shahriyar13.ecommerce.domain.common.BaseUseCase
import com.github_shahriyar13.ecommerce.domain.entities.UserEntity
import com.github_shahriyar13.ecommerce.infrastructure.jpa.repositories.AccountRepository

class UpdateUserUseCase(
    private val accountRepository: AccountRepository
): BaseUseCase<UserEntity, UserEntity>() {

    override fun execute(params: UserEntity) = accountRepository.save(params)
}