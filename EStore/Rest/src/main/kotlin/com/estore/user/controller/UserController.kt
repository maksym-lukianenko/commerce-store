package com.estore.user.controller

import com.estore.context.GenericContext
import com.estore.user.mapper.UserInfoMapper
import com.estore.user.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController {

    @Autowired
    lateinit var userService: UserService
    @Autowired
    lateinit var userInfoMapper: UserInfoMapper
    @Autowired
    lateinit var context: GenericContext

    @GetMapping("/user/{userId}")
    fun get(@PathVariable userId: String) = userInfoMapper.map(userService.getUser(userId))
}