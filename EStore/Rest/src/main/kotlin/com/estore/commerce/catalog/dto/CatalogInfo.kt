package com.estore.commerce.catalog.dto

import com.estore.commerce.catalog.category.dto.CategoryInfo

class CatalogInfo {

    lateinit var id: String

    lateinit var name: String

    lateinit var rootCategories: Collection<CategoryInfo>
}