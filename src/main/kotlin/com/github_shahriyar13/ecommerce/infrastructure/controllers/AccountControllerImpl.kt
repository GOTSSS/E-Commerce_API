package com.github_shahriyar13.ecommerce.infrastructure.controllers

import com.github_shahriyar13.ecommerce.domain.entities.UserEntity
import com.github_shahriyar13.ecommerce.domain.usecases.account.AddUserUseCase
import com.github_shahriyar13.ecommerce.domain.usecases.account.GetUserByMobileUseCase
import com.github_shahriyar13.ecommerce.domain.usecases.account.UpdateUserUseCase
import com.github_shahriyar13.ecommerce.presentation.common.BaseResponse
import com.github_shahriyar13.ecommerce.presentation.common.ResponseResult
import com.github_shahriyar13.ecommerce.presentation.controllers.AccountController
import com.github_shahriyar13.ecommerce.presentation.dtos.SignInResponseDto
import kotlin.random.Random

class AccountControllerImpl(
    private val addUserUseCase: AddUserUseCase,
    private val updateUserUseCase: UpdateUserUseCase,
    private val getUserByMobileUseCase: GetUserByMobileUseCase,
): AccountController {

    override fun signIn(mobile: String, encryptedPassword: String): BaseResponse<ResponseResult<SignInResponseDto>> {
        var res = getUserByMobileUseCase.execute(mobile) ?: return BaseResponse.Error("Wrong User/Pass")
        if (encryptedPassword.isNotEmpty() && res.password != encryptedPassword) return BaseResponse.Error("Wrong User/Pass")
        res.active = true
        res = updateUserUseCase.execute(res)
        val token = "userId=${res.id}"//todo: token
        return BaseResponse.Success(SignInResponseDto(token = token, user = res))
    }

    override fun signOut(): BaseResponse<ResponseResult<UserEntity>> {
        TODO("Not yet implemented")
    }

    override fun signUp(mobile: String): BaseResponse<ResponseResult<Unit>> {
        var res = getUserByMobileUseCase.execute(mobile)
        if (res == null) {
            res = addUserUseCase.execute(UserEntity(username = mobile, active = false, roles = listOf("USER"), email = null, password = Random.nextInt(0, 9999).toString().padStart(4, '0')))
        }
        //todo: send activation code
        return BaseResponse.SuccessEmpty("Activation code sent to your mobile")
    }
}