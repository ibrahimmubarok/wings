package com.ibrahim.wingstestcandidate.data.network

import com.ibrahim.wingstestcandidate.data.model.LoginResponse
import com.ibrahim.wingstestcandidate.data.model.ProductsResponse
import com.ibrahim.wingstestcandidate.data.model.TransactionHeaderResponse
import com.ibrahim.wingstestcandidate.util.BaseResponse
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @POST("transaction_header")
    suspend fun postTransaction(@Body transactionRequest: TransactionHeaderResponse): Response<BaseResponse<TransactionHeaderResponse>>

    @GET("login")
    suspend fun getAccount(): Response<BaseResponse<LoginResponse>>

    @GET("products")
    suspend fun getListProducts(): Response<BaseResponse<List<ProductsResponse>>>
}