package com.estore.user.service

import com.estore.user.entity.User

interface UserService {

    fun getUser(id: String): User
}