package com.github_shahriyar13.ecommerce.domain.usecases.basket

import com.github_shahriyar13.ecommerce.domain.common.BaseUseCase
import com.github_shahriyar13.ecommerce.domain.entities.BasketEntity
import com.github_shahriyar13.ecommerce.domain.entities.params.AddProductToBasketParams

class AddProductToBasketUseCase(): BaseUseCase<AddProductToBasketParams, BasketEntity>() {

    override fun execute(params: AddProductToBasketParams): BasketEntity? {
        return null
    }
}