package com.github_shahriyar13.ecommerce.domain.usecases.basket

import com.github_shahriyar13.ecommerce.domain.common.BaseUseCase
import com.github_shahriyar13.ecommerce.domain.entities.BasketEntity

class GetBasketsUseCase(

): BaseUseCase<Unit?, List<BasketEntity>>() {

    override fun execute(params: Unit?): List<BasketEntity>? {
        return null
    }
}