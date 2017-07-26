package com.estore.commerce.pricing.entity

import com.estore.commerce.catalog.entity.Sku
import org.joda.money.CurrencyUnit
import org.joda.money.Money
import java.io.Serializable
import javax.persistence.*

@Entity
@Table(name = "PRICE")
class Price : Serializable {

    @Id
    lateinit var id: String

    @Column(name = "BASE_PRICE", nullable = false)
    lateinit var basePrice: Money

    @Column(name = "SALE_PRICE", nullable = false)
    lateinit var salePrice: Money

    @Column(name = "CURRENCY_UNIT", nullable = false)
    lateinit var currencyUnit: CurrencyUnit

    @OneToOne(optional = false)
    lateinit var priceList: PriceList

    @OneToOne(optional = false)
    lateinit var sku: Sku

    override fun toString() = "Price(id='$id', basePrice=$basePrice, salePrice=$salePrice, currencyUnit=$currencyUnit, sku=$sku)"
}

