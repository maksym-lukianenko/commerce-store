package com.estore.commerce.catalog.service.impl

import com.estore.commerce.catalog.entity.Catalog
import com.estore.commerce.catalog.repository.CatalogRepository
import com.estore.commerce.catalog.service.CatalogService
import com.estore.exception.ItemNotFoundException
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CatalogServiceImpl : CatalogService {

    @Autowired
    lateinit var catalogRepository: CatalogRepository

    override fun getCatalog(id: String): Catalog {
        return catalogRepository.findOne(id) ?: throw ItemNotFoundException("Catalog with id: '$id' not found.")
    }

    override fun createCatalog(catalog: Catalog): Catalog {
        return catalogRepository.save(catalog)
    }
}
