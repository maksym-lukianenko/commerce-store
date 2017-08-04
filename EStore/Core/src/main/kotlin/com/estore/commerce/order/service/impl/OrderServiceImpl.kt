package com.estore.commerce.order.service.impl

import com.estore.commerce.order.entity.Order
import com.estore.commerce.order.repository.OrderRepository
import com.estore.commerce.order.service.OrderService
import com.estore.exception.ItemNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class OrderServiceImpl : OrderService {

    @Autowired
    lateinit var orderRepository: OrderRepository

    override fun getOrder(id: String): Order {
        return orderRepository.findOne(id) ?: throw ItemNotFoundException("Order with id: '$id' not found.")
    }

    override fun createOrder(order: Order): Order {
        return orderRepository.save(order)
    }
}