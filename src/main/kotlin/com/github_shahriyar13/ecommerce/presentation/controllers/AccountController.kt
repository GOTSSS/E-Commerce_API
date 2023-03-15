package com.github_shahriyar13.ecommerce.presentation.controllers

import com.github_shahriyar13.ecommerce.domain.entities.UserEntity
import com.github_shahriyar13.ecommerce.presentation.common.BaseResponse
import com.github_shahriyar13.ecommerce.presentation.common.ControllersPaths.baseApiPath
import com.github_shahriyar13.ecommerce.presentation.common.ResponseResult
import com.github_shahriyar13.ecommerce.presentation.dtos.SignInResponseDto
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping(baseApiPath + "account")
interface AccountController {

    @GetMapping("/v1/sign-in")
    fun signIn(
        @RequestParam mobile: String,
        @RequestParam encryptedPassword: String,
    ): BaseResponse<ResponseResult<SignInResponseDto>>

    @GetMapping("/v1/sign-out")
    fun signOut(): BaseResponse<ResponseResult<UserEntity>>

    @GetMapping("/v1/sign-up")
    fun signUp(
        @RequestParam mobile: String,
    ): BaseResponse<ResponseResult<Unit>>
}