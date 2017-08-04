package com.estore.commerce.catalog.product.entity

import com.estore.commerce.catalog.category.entity.Category
import org.apache.commons.lang3.StringUtils
import org.hibernate.annotations.GenericGenerator
import java.io.Serializable
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "PRODUCT")
class Product : Serializable {

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

    @Column(name = "ON_SALE")
    var onSale: Boolean = false

    @ManyToMany(mappedBy = "childProducts")
    var parentCategories: MutableCollection<Category> = mutableSetOf()

    @OneToOne(mappedBy = "parentProduct")
    lateinit var defaultSku: Sku

    @OneToMany(cascade = arrayOf(CascadeType.ALL), mappedBy = "parentProduct")
    var childSkus: MutableCollection<Sku> = mutableSetOf()

    override fun toString(): String = "Product(id='$id', defaultName='$name')"
}
