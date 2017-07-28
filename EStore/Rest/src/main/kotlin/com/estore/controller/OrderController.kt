package com.estore.controller

import com.estore.commerce.order.entity.Order
import com.estore.repository.OrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController {

    @Autowired lateinit var orderRepository: OrderRepository

    @PostMapping("/order")
    fun create() = orderRepository.save(Order())

    @GetMapping("/order/{orderId}")
    fun get(@PathVariable orderId: String) = orderRepository.findOne(orderId)
}