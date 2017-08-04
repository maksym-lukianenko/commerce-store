package com.estore.commerce.catalog.dto.catalog

import com.estore.commerce.catalog.category.dto.CategoryInfo
import org.apache.commons.lang3.StringUtils

class CatalogInfo {

    var id: String = StringUtils.EMPTY

    var name: String = StringUtils.EMPTY

    var rootCategories: Collection<CategoryInfo> = listOf()
}