package com.estore.commerce.catalog.category.repository

import com.estore.commerce.catalog.category.entity.Category
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CategoryRepository : CrudRepository<Category, String>