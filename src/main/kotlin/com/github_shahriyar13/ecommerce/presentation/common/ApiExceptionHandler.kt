package com.github_shahriyar13.ecommerce.presentation.common

import org.hibernate.exception.ConstraintViolationException
import org.springframework.data.rest.webmvc.ResourceNotFoundException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ApiExceptionHandler {

    @ExceptionHandler(ConstraintViolationException::class)
    fun handle(e: ConstraintViolationException) = BaseResponse.Error<Unit>(e.message)

    @ExceptionHandler(ResourceNotFoundException::class)
    fun handle(e: ResourceNotFoundException) = BaseResponse.Error<Unit>(e.message)
}