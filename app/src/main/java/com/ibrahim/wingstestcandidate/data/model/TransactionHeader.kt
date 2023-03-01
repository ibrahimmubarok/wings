package com.ibrahim.wingstestcandidate.data.model

data class TransactionHeader(
    val documentCode: String,
    val documentNumber: String,
    val user: String,
    val total: Double,
    val date: String
)