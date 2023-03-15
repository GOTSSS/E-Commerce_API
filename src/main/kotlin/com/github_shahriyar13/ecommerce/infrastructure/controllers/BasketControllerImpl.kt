package com.github_shahriyar13.ecommerce.infrastructure.controllers

import com.github_shahriyar13.ecommerce.domain.entities.BasketEntity
import com.github_shahriyar13.ecommerce.domain.entities.params.AddProductToBasketParams
import com.github_shahriyar13.ecommerce.domain.usecases.basket.AddProductToBasketUseCase
import com.github_shahriyar13.ecommerce.domain.usecases.basket.DeleteBasketByIdUseCase
import com.github_shahriyar13.ecommerce.domain.usecases.basket.GetBasketByIdUseCase
import com.github_shahriyar13.ecommerce.domain.usecases.basket.GetBasketsUseCase
import com.github_shahriyar13.ecommerce.presentation.common.BaseResponse
import com.github_shahriyar13.ecommerce.presentation.common.ResponseResult
import com.github_shahriyar13.ecommerce.presentation.controllers.BasketController
import com.github_shahriyar13.ecommerce.presentation.dtos.AddProductToBasketRequestDto

class BasketControllerImpl(
    private val getBasketsUseCase: GetBasketsUseCase,
    private val getBasketByIdUseCase: GetBasketByIdUseCase,
    private val addProductToBasketUseCase: AddProductToBasketUseCase,
    private val deleteBasketByIdUseCase: DeleteBasketByIdUseCase,
): BasketController {

    override fun getBasket(basketId: Long): BaseResponse<ResponseResult<BasketEntity>> {
        val res = getBasketByIdUseCase.execute(basketId) ?: return BaseResponse.Error("Not found")
        return BaseResponse.Success(res)
    }

    override fun getBasket(): BaseResponse<ResponseResult<List<BasketEntity>>> {
        val res = getBasketsUseCase.execute(null) ?: return BaseResponse.Error("Not found")
        return BaseResponse.Success(res)
    }

    override fun addProductToBasket(
        basketId: Long,
        request: AddProductToBasketRequestDto
    ): BaseResponse<ResponseResult<BasketEntity>> {
        val res = addProductToBasketUseCase.execute(
            AddProductToBasketParams(
                basketId = basketId,
                productId = request.productId,
                quantity = request.quantity,
            )
        ) ?: return BaseResponse.Error("Not found")
        return BaseResponse.Success(res)
    }

    override fun deleteBasket(basketId: Long): BaseResponse<ResponseResult<BasketEntity>> {
        val res = deleteBasketByIdUseCase.execute(basketId) ?: return BaseResponse.Error("Not found")
        return BaseResponse.Success(res)
    }
}