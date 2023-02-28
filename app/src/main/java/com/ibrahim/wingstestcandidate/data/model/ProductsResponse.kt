package com.ibrahim.wingstestcandidate.data.model

import com.google.gson.annotations.SerializedName

data class ProductsResponse(
    @SerializedName("currency")
    val currency: String,
    @SerializedName("dimension")
    val dimension: String,
    @SerializedName("discount")
    val discount: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("price")
    val price: Int,
    @SerializedName("product_code")
    val productCode: Int,
    @SerializedName("product_name")
    val productName: String,
    @SerializedName("unit")
    val unit: String
)