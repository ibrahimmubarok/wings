package com.ibrahim.wingstestcandidate.data.local

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("login")
data class LoginEntity(
    @PrimaryKey
    @ColumnInfo("user")
    val user: String,
    val password: String
)

@Entity("product")
data class ProductEntity(
    @PrimaryKey
    val productCode: String,
    val productName: String,
    val price: Double,
    val currency: String,
    val discount: Double,
    val dimension: String,
    val unit: String
)

@Entity("transaction_header")
data class TransactionHeaderEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0,
    val documentCode: String,
    val documentNumber: String,
    val user: String,
    val total: Double,
    val date: String
)

@Entity("transaction_detail")
data class TransactionDetailEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = 0,
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