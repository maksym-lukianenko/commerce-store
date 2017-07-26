package com.estore.commerce.catalog.entity

import java.io.Serializable
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "PRODUCT")
class Product : Serializable {

    @Id
    lateinit var id: String

    @Column(name = "START_DATE")
    lateinit var startDate: LocalDate

    @Column(name = "NAME", nullable = false)
    lateinit var name: String

    @Column(name = "DESCRIPTION")
    lateinit var description: String

    @Column(name = "ON_SALE")
    var onSale: Boolean = false

    @ManyToMany(mappedBy = "childProducts")
    lateinit var parentCategories: Set<Category>

    @OneToOne(mappedBy = "parentProduct")
    lateinit var defaultSku: Sku

    @OneToMany(cascade = arrayOf(CascadeType.ALL), mappedBy = "parentProduct")
    var childSkus: MutableSet<Sku> = mutableSetOf()

    override fun toString(): String = "Product(id='$id', defaultName='$name')"
}
