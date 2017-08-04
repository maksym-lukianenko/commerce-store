package com.estore.commerce.catalog.category.service

import com.estore.commerce.catalog.category.entity.Category

interface CategoryService {

    fun getCategory(id: String): Category

    fun createCategory(category: Category): Category
}