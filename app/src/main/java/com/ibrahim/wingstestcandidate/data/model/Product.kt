package com.ibrahim.wingstestcandidate.data.model

data class Product(
    val productCode: String,
    val productName: String,
    val price: Double,
    val currency: String,
    val discount: Double,
    val dimension: String,
    val unit: String,
)
