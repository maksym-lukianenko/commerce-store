package com.estore.commerce.catalog.mapper

import com.estore.commerce.catalog.category.mapper.CategoryInfoMapper
import com.estore.commerce.catalog.dto.CatalogInfo
import com.estore.commerce.catalog.entity.Catalog
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CatalogInfoMapper {

    @Autowired
    lateinit var categoryInfoMapper: CategoryInfoMapper

    fun map(catalog: Catalog): CatalogInfo {
        val catalogInfo = CatalogInfo()
        catalogInfo.id = catalog.id
        catalogInfo.name = catalog.name
        catalogInfo.rootCategories = categoryInfoMapper.map(catalog.rootCategories)
        return catalogInfo
    }
}