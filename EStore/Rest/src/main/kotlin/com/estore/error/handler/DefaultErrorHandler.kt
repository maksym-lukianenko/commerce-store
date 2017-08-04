package com.estore.error.handler

import com.estore.error.dto.ErrorInfo
import com.estore.error.mapper.ErrorInfoMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.Ordered.LOWEST_PRECEDENCE
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus


@ControllerAdvice
@Order(LOWEST_PRECEDENCE)
class DefaultErrorHandler {

    @Autowired
    lateinit var errorInfoMapper: ErrorInfoMapper

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    fun defaultErrorHandler(exception: Exception): ErrorInfo {
        return errorInfoMapper.mapException(exception)
    }
}