package com.estore.user.service.impl

import com.estore.exception.ItemNotFoundException
import com.estore.user.entity.User
import com.estore.user.repository.UserRepository
import com.estore.user.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class UserServiceImpl : UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    override fun getUser(id: String): User {
        return userRepository.findOne(id) ?: throw ItemNotFoundException("User with id: '$id' not found.")
    }
}