package com.estore.commerce.order.entity

import org.apache.commons.lang3.StringUtils
import org.hibernate.annotations.GenericGenerator
import java.io.Serializable
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "ORDER")
class Order : Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    var id: String = StringUtils.EMPTY

    override fun toString() = "Order(id='$id')"
}
