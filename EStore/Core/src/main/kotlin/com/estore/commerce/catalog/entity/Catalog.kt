package com.estore.commerce.catalog.entity

import com.estore.commerce.catalog.category.entity.Category
import org.apache.commons.lang3.StringUtils
import org.hibernate.annotations.GenericGenerator
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "CATALOG")
class Catalog : Serializable {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    var id: String = StringUtils.EMPTY

    @Column(name = "NAME", nullable = false)
    lateinit var name: String

    @OneToMany(cascade = arrayOf(CascadeType.ALL), mappedBy = "parentCatalog", fetch = FetchType.LAZY)
    lateinit var rootCategories: MutableCollection<Category>

    override fun toString() = "Catalog(id='$id', name='$name')"
}