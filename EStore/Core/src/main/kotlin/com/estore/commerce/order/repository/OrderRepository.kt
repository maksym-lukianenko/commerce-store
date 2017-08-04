package com.estore.commerce.order.repository

import com.estore.commerce.order.entity.Order
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface OrderRepository : CrudRepository<Order, String>