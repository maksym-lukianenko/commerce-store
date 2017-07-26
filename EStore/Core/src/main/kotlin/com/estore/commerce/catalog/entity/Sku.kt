package com.estore.commerce.catalog.entity

import com.estore.commerce.pricing.entity.Price
import java.io.Serializable
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "SKU")
class Sku : Serializable {

    @Id
    lateinit var id: String

    @Column(name = "START_DATE")
    lateinit var startDate: LocalDate

    @Column(name = "NAME", nullable = false)
    lateinit var name: String

    @Column(name = "DESCRIPTION")
    lateinit var description: String

    @ManyToOne
    @JoinColumn(name = "PARENT_PRODUCT_ID", nullable = false)
    lateinit var parentProduct: Product

    @Column(name = "PRICE")
    lateinit var price: Price

    override fun toString() = "Sku(id='$id', name='$name')"
}
