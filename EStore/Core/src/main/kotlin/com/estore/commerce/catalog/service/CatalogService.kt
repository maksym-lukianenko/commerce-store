package com.estore.commerce.catalog.service

import com.estore.commerce.catalog.entity.Catalog

interface CatalogService {

    fun getCatalog(id: String): Catalog

    fun createCatalog(catalog: Catalog): Catalog
}