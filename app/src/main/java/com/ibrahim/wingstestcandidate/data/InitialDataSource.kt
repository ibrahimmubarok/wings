package com.ibrahim.wingstestcandidate.data

import com.ibrahim.wingstestcandidate.data.local.LoginEntity
import com.ibrahim.wingstestcandidate.data.local.ProductEntity

object InitialDataSource {
    fun getLogin(): List<LoginEntity> {
        return listOf(
            LoginEntity(
                user = "Smit",
                password = "_sm1t_OK"
            )
        )
    }

    fun getProducts(): List<ProductEntity> {
        return listOf(
            ProductEntity(
                productCode = "SKP",
                productName = "So Klin Pewangi",
                price = 15000.0,
                currency = "IDR",
                discount = 0.10,
                dimension = "13 cm x 10 cm",
                unit = "PCS"
            ),
            ProductEntity(
                productCode = "GB",
                productName = "Giv Biru",
                price = 11000.0,
                currency = "IDR",
                discount = 0.0,
                dimension = "13 cm x 10 cm",
                unit = "PCS"
            ),
            ProductEntity(
                productCode = "SKL",
                productName = "So Klin Liquid",
                price = 18000.0,
                currency = "IDR",
                discount = 0.0,
                dimension = "13 cm x 10 cm",
                unit = "PCS"
            ),
            ProductEntity(
                productCode = "GK",
                productName = "Giv Kuning",
                price = 10000.0,
                currency = "IDR",
                discount = 0.0,
                dimension = "13 cm x 10 cm",
                unit = "PCS"
            )
        )
    }
}