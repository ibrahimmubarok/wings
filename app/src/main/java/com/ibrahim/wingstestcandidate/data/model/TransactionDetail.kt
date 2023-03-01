package com.ibrahim.wingstestcandidate.data.model

data class TransactionDetail(
    val documentCode: String,
    val documentNumber: String,
    val productCode: String,
    val productName: String,
    val price: Double,
    val quantity: Int,
    val unit: String,
    val subTotal: Double,
    val currency: String
)