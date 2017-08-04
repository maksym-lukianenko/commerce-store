package com.estore.commerce.order.service

import com.estore.commerce.order.entity.Order

interface OrderService {

    fun getOrder(id: String): Order

    fun createOrder(order: Order): Order
}