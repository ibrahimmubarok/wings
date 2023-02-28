package com.ibrahim.wingstestcandidate.data.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("password")
    val password: String,
    @SerializedName("user")
    val user: String
)