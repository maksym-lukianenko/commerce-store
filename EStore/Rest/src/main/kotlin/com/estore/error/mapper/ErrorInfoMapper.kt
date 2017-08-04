package com.estore.error.mapper

import com.estore.error.dto.ErrorInfo
import org.springframework.stereotype.Component

@Component
class ErrorInfoMapper {

    fun mapException(exception: Exception): ErrorInfo {
        val errorInfo = ErrorInfo()
        errorInfo.message = exception.message
        return errorInfo
    }
}