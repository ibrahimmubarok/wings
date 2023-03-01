package com.ibrahim.wingstestcandidate.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val productCode: String,
    val productName: String,
    val price: Double,
    val currency: String,
    val discount: Double,
    val dimension: String,
    val unit: String,
    val quantity: Int = 0
) : Parcelable
