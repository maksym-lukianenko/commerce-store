package com.estore.commerce.catalog.entity

import java.io.Serializable
import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "CATEGORY")
class Category : Serializable {

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

    @ManyToOne
    @JoinColumn(name = "PARENT_CATALOG_ID", nullable = false)
    lateinit var parentCatalog: Catalog

    @ManyToOne(cascade = arrayOf(CascadeType.ALL))
    @JoinColumn(name = "PARENT_CATEGORY_ID")
    lateinit var parentCategory: Category

    @OneToMany(mappedBy = "parentCategory")
    var childCategories: MutableSet<Category> = mutableSetOf()

    @ManyToMany
    @JoinTable(name = "CATEGORY_PRODUCTS",
            joinColumns = arrayOf(JoinColumn(name = "CATEGORY_ID", referencedColumnName = "ID")),
            inverseJoinColumns = arrayOf(JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID"))
    )
    var childProducts: MutableSet<Product> = mutableSetOf()

    override fun toString() = "Category(id='$id', name='$name')"
}