package com.estore.controller

import com.estore.commerce.order.entity.Order
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController {

    @GetMapping("/order/{orderId}")
    fun get(@PathVariable orderId: String) = Order(orderId)
}