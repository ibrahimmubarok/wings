package com.ibrahim.wingstestcandidate.data.model

import com.google.gson.annotations.SerializedName

data class TransactionDetailResponse(
    @SerializedName("currency")
    val currency: String,
    @SerializedName("document_code")
    val documentCode: String,
    @SerializedName("document_number")
    val documentNumber: String,
    @SerializedName("price")
    val price: Int,
    @SerializedName("product_code")
    val productCode: String,
    @SerializedName("quantity")
    val quantity: Int,
    @SerializedName("sub_total")
    val subTotal: Int,
    @SerializedName("unit")
    val unit: String
)