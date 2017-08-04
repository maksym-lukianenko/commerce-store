package com.estore.commerce.catalog.category.mapper

import com.estore.commerce.catalog.category.dto.CategoryInfo
import com.estore.commerce.catalog.category.entity.Category
import org.springframework.stereotype.Component

@Component
class CategoryInfoMapper {

    fun map(category: Category): CategoryInfo {
        val categoryInfo = CategoryInfo()
        categoryInfo.id = category.id
        categoryInfo.name = category.name
        categoryInfo.description = category.description
        categoryInfo.onSale = category.onSale
        return categoryInfo
    }

    fun map(categories: Collection<Category>): Collection<CategoryInfo> {
        return categories.map { map(it) }
    }
}