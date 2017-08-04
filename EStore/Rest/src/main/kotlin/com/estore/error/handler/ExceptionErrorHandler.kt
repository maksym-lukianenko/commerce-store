package com.estore.error.handler

import com.estore.error.dto.ErrorInfo
import com.estore.error.mapper.ErrorInfoMapper
import com.estore.exception.ItemNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.Ordered.HIGHEST_PRECEDENCE
import org.springframework.core.annotation.Order
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus


@ControllerAdvice
@Order(HIGHEST_PRECEDENCE)
class ExceptionErrorHandler {

    @Autowired
    lateinit var errorInfoMapper: ErrorInfoMapper

    @ExceptionHandler(ItemNotFoundException::class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    fun handleNotFoundException(exception: ItemNotFoundException): ErrorInfo {
        return errorInfoMapper.mapException(exception)
    }
}