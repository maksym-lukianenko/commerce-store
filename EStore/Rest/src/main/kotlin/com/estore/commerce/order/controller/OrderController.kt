package com.estore.commerce.order.controller

import com.estore.commerce.order.entity.Order
import com.estore.commerce.order.mapper.OrderInfoMapper
import com.estore.commerce.order.service.OrderService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController {

    @Autowired
    lateinit var orderService: OrderService
    @Autowired
    lateinit var orderInfoMapper: OrderInfoMapper

    @GetMapping("/order/{orderId}")
    fun get(@PathVariable orderId: String) = orderInfoMapper.map(orderService.getOrder(orderId))

    @PostMapping("/order")
    fun create() = orderInfoMapper.map(orderService.createOrder(Order()))
}