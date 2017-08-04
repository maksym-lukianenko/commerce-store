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
    var startDate: LocalDate? = null

    @Column(name = "NAME", nullable = false)
    lateinit var name: String

    @Column(name = "DESCRIPTION")
    var description: String? = null

    @Column(name = "ON_SALE")
    var onSale: Boolean = false

    @ManyToMany(mappedBy = "childProducts", fetch = FetchType.LAZY)
    lateinit var parentCategories: MutableCollection<Category>

    @OneToOne(mappedBy = "parentProduct", optional = false)
    lateinit var defaultSku: Sku

    @OneToMany(cascade = arrayOf(CascadeType.ALL), mappedBy = "parentProduct", fetch = FetchType.LAZY)
    lateinit var childSkus: MutableCollection<Sku>

    override fun toString(): String = "Product(id='$id', defaultName='$name')"
}
