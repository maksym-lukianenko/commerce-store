package com.estore.commerce.catalog.entity

import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "CATALOG")
class Catalog : Serializable {

    @Id
    lateinit var id: String

    @Column(name = "NAME", nullable = false)
    lateinit var name: String

    @OneToMany(cascade = arrayOf(CascadeType.ALL), mappedBy = "parentCatalog")
    var rootCategories: MutableSet<Category> = mutableSetOf()

    override fun toString() = "Catalog(id='$id', name='$name')"
}