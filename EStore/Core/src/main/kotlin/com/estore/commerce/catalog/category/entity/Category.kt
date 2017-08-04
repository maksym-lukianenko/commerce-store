package com.estore.commerce.catalog.category.entity

import com.estore.commerce.catalog.entity.Catalog
import com.estore.commerce.catalog.product.entity.Product
import org.apache.commons.lang3.StringUtils
import org.hibernate.annotations.GenericGenerator
import java.io.Serializable
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "CATEGORY")
class Category : Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    var id: String = StringUtils.EMPTY

    @Column(name = "START_DATE")
    var startDate: LocalDate = LocalDate.now()

    @Column(name = "NAME", nullable = false)
    lateinit var name: String

    @Column(name = "DESCRIPTION")
    var description: String = StringUtils.EMPTY

    @Column(name = "ON_SALE")
    var onSale: Boolean = false

    @ManyToOne
    @JoinColumn(name = "PARENT_CATALOG_ID", nullable = false)
    lateinit var parentCatalog: Catalog

    @ManyToOne(cascade = arrayOf(CascadeType.ALL))
    @JoinColumn(name = "PARENT_CATEGORY_ID")
    var parentCategory: Category? = null

    @OneToMany(mappedBy = "parentCategory")
    var childCategories: MutableCollection<Category> = mutableSetOf()

    @ManyToMany
    @JoinTable(name = "CATEGORY_PRODUCTS",
            joinColumns = arrayOf(JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")),
            inverseJoinColumns = arrayOf(JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID"))
    )
    var childProducts: MutableCollection<Product> = mutableSetOf()

    override fun toString() = "Category(id='$id', name='$name')"
}