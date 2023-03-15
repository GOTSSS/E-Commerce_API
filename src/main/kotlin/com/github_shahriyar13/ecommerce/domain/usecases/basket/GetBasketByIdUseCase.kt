package com.github_shahriyar13.ecommerce.domain.usecases.basket

import com.github_shahriyar13.ecommerce.domain.common.BaseUseCase
import com.github_shahriyar13.ecommerce.domain.entities.BasketEntity

class GetBasketByIdUseCase(

): BaseUseCase<Long, BasketEntity>() {

    override fun execute(params: Long): BasketEntity? {
        return null
    }
}