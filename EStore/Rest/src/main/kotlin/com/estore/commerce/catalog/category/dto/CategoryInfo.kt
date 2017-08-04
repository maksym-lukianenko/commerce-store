package com.estore.commerce.catalog.category.dto

class CategoryInfo {

    lateinit var id: String

    lateinit var name: String

    var description: String? = null

    var onSale: Boolean = false

    lateinit var childCategories: Collection<CategoryInfo>
}