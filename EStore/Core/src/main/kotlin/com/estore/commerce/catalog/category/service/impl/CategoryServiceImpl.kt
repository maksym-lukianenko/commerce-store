package com.estore.commerce.catalog.category.service.impl

import com.estore.commerce.catalog.category.entity.Category
import com.estore.commerce.catalog.category.repository.CategoryRepository
import com.estore.commerce.catalog.category.service.CategoryService
import com.estore.exception.ItemNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CategoryServiceImpl : CategoryService {

    @Autowired
    lateinit var categoryRepository: CategoryRepository

    override fun getCategory(id: String): Category {
        return categoryRepository.findOne(id) ?: throw ItemNotFoundException("Category with id: $id not found.")
    }

    override fun createCategory(category: Category): Category {
        return categoryRepository.save(category)
    }
}