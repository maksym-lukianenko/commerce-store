package com.estore.commerce.order.entity

import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "ORDER")
class Order(@Id var id: String) : Serializable {

    override fun toString() = "Order(id='$id')"
}
