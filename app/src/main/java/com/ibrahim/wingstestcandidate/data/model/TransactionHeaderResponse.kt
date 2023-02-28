package com.ibrahim.wingstestcandidate.data.model

import com.google.gson.annotations.SerializedName

data class TransactionHeaderResponse(
    @SerializedName("date")
    val date: String,
    @SerializedName("document_code")
    val documentCode: String,
    @SerializedName("document_number")
    val documentNumber: String,
    @SerializedName("total")
    val total: Int,
    @SerializedName("user")
    val user: String
)