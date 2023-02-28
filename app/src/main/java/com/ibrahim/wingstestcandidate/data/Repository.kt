package com.ibrahim.wingstestcandidate.data

import com.ibrahim.wingstestcandidate.data.model.LoginResponse
import com.ibrahim.wingstestcandidate.data.model.ProductsResponse
import com.ibrahim.wingstestcandidate.data.model.TransactionHeaderResponse
import com.ibrahim.wingstestcandidate.data.network.ApiService
import com.ibrahim.wingstestcandidate.util.BaseResponse
import retrofit2.Response

class Repository(private val apiService: ApiService) {

//    suspend fun getMovies(): Response<ListMovieOrTvShowResponse> {
//        return apiService.getMovies()
//    }
//
//    suspend fun getTvShows(): Response<ListMovieOrTvShowResponse> {
//        return apiService.getTvShows()
//    }

    suspend fun postTransaction(transactionRequest: TransactionHeaderResponse): Response<BaseResponse<TransactionHeaderResponse>> {
        return apiService.postTransaction(transactionRequest)
    }

    suspend fun getUserAccount(): Response<BaseResponse<LoginResponse>> {
        return apiService.getAccount()
    }

    suspend fun getListProducts(): Response<BaseResponse<List<ProductsResponse>>> {
        return apiService.getListProducts()
    }
}