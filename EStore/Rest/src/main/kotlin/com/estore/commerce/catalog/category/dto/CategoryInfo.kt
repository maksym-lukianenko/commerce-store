package com.estore.commerce.catalog.category.dto

import org.apache.commons.lang3.StringUtils

class CategoryInfo {

    var id: String = StringUtils.EMPTY

    var name: String = StringUtils.EMPTY

    var description: String = StringUtils.EMPTY

    var onSale: Boolean = false

    var childCategories: Collection<CategoryInfo> = listOf()
}