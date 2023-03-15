package com.github_shahriyar13.ecommerce.presentation.controllers

import com.github_shahriyar13.ecommerce.domain.entities.BasketEntity
import com.github_shahriyar13.ecommerce.presentation.common.BaseResponse
import com.github_shahriyar13.ecommerce.presentation.common.ControllersPaths
import com.github_shahriyar13.ecommerce.presentation.common.ResponseResult
import com.github_shahriyar13.ecommerce.presentation.dtos.AddProductToBasketRequestDto
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(ControllersPaths.baseApiPath + "basket")
interface BasketController {

    @GetMapping("/v1/{basketId}")
    fun getBasket(
        @PathVariable basketId: Long
    ): BaseResponse<ResponseResult<BasketEntity>>

    @GetMapping("/v1/all")
    fun getBasket(): BaseResponse<ResponseResult<List<BasketEntity>>>

    @PostMapping("/v1/{basketId}/addProduct")
    fun addProductToBasket(
        @PathVariable basketId: Long,
        @RequestParam request: AddProductToBasketRequestDto
    ): BaseResponse<ResponseResult<BasketEntity>>

    @DeleteMapping("/v1/{basketId}/delete")
    fun deleteBasket(
        @PathVariable basketId: Long,
    ): BaseResponse<ResponseResult<BasketEntity>>
}