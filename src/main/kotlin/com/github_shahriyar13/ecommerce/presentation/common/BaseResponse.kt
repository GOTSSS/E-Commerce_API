package com.github_shahriyar13.ecommerce.presentation.common

import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity

sealed class BaseResponse<T>(result: T? = null, statusCode: HttpStatusCode): ResponseEntity<T>(result, statusCode) {
    data class Success<T>(val data: T, val message: String? = null): BaseResponse<ResponseResult<T>>(
        ResponseResult(
            data = data,
            code = 200,
            friendlyMessage = message,
        ),
        HttpStatusCode.valueOf(200)
    )
    class SuccessEmpty<T>(message: String? = null): BaseResponse<ResponseResult<T>>(
        ResponseResult(
            code = 200,
            friendlyMessage = message,
        ),
        HttpStatusCode.valueOf(200)
    )

    class Error<T>(message: String?): BaseResponse<ResponseResult<T>>(
        ResponseResult(
            code = 500,
            errorMessage = message,
        ),
        HttpStatusCode.valueOf(500),
    )

    class UnAuthorized<T>: BaseResponse<ResponseResult<T>>(
        ResponseResult(
            code = 401,
        ),
        HttpStatusCode.valueOf(401),
    )

    class AccessDenied<T>: BaseResponse<ResponseResult<T>>(
        ResponseResult(
            code = 403,
        ),
        HttpStatusCode.valueOf(403),
    )
}