package com.estore.commerce.pricing.entity

import java.io.Serializable
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "PRICE_LIST")
class PriceList : Serializable {

    @Id
    lateinit var id: String

    @Column(name = "NAME", nullable = false)
    lateinit var name: String

    @OneToOne(optional = false)
    @JoinColumn(name = "BASE_PRICE_LIST_ID")
    lateinit var basePriceList: PriceList

    @Column(name = "LOCALE", nullable = false)
    lateinit var locale: Locale

    override fun toString() = "PriceList(id='$id', name='$name')"
}