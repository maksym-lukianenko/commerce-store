package com.estore.commerce.catalog.controller

import com.estore.commerce.catalog.dto.CatalogInfo
import com.estore.commerce.catalog.mapper.CatalogInfoMapper
import com.estore.commerce.catalog.service.CatalogService
import com.estore.context.GenericContext
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class CatalogController {

    @Autowired
    lateinit var catalogService: CatalogService
    @Autowired
    lateinit var catalogInfoMapper: CatalogInfoMapper
    @Autowired
    lateinit var context: GenericContext

    @GetMapping("/catalog/{catalogId}")
    fun get(@PathVariable catalogId: String): CatalogInfo = catalogInfoMapper.map(catalogService.getCatalog(catalogId))
}