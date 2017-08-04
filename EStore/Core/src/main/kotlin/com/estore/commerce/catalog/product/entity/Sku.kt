package com.estore.commerce.catalog.product.entity

import com.estore.commerce.pricing.entity.Price
import org.apache.commons.lang3.StringUtils
import org.hibernate.annotations.GenericGenerator
import java.io.Serializable
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "SKU")
class Sku : Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    var id: String = StringUtils.EMPTY

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
