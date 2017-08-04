package com.estore.commerce.order.mapper

import com.estore.commerce.order.dto.OrderInfo
import com.estore.commerce.order.entity.Order
import org.springframework.stereotype.Component

@Component
class OrderInfoMapper {

    fun map(order: Order): OrderInfo {
        val orderInfo = OrderInfo()
        orderInfo.id = order.id
        return orderInfo
    }
}