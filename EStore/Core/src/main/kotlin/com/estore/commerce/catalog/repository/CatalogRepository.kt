package com.estore.commerce.catalog.repository

import com.estore.commerce.catalog.entity.Catalog
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CatalogRepository : CrudRepository<Catalog, String>