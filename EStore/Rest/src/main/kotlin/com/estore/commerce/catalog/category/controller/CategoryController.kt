package com.estore.commerce.catalog.category.controller

import com.estore.commerce.catalog.category.mapper.CategoryInfoMapper
import com.estore.commerce.catalog.category.service.CategoryService
import com.estore.context.GenericContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CategoryController {

    @Autowired
    lateinit var categoryService: CategoryService
    @Autowired
    lateinit var categoryInfoMapper: CategoryInfoMapper
    @Autowired
    lateinit var context: GenericContext

    @GetMapping("/category/{categoryId}")
    fun get(@PathVariable categoryId: String) = categoryInfoMapper.map(categoryService.getCategory(categoryId))
}