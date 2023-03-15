package com.github_shahriyar13.ecommerce.domain.common

import com.github_shahriyar13.ecommerce.presentation.common.BaseResponse
import com.github_shahriyar13.ecommerce.presentation.common.ResponseResult

abstract class BaseUseCase<in T, R> {
    abstract fun execute(params: T): R?
}