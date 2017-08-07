package com.estore.user.mapper

import com.estore.user.dto.UserInfo
import com.estore.user.entity.User
import org.springframework.stereotype.Component

@Component
class UserInfoMapper {

    fun map(user: User): UserInfo {
        val userInfo = UserInfo()
        userInfo.id = user.id
        return userInfo
    }
}