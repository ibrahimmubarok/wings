package com.ibrahim.wingstestcandidate.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ibrahim.wingstestcandidate.data.Repository
import com.ibrahim.wingstestcandidate.data.model.LoginResponse
import com.ibrahim.wingstestcandidate.data.model.ProductsResponse
import com.ibrahim.wingstestcandidate.data.model.TransactionHeaderResponse
import com.ibrahim.wingstestcandidate.util.BaseResponse
import kotlinx.coroutines.launch

class MainViewModel(private val repository: Repository) : ViewModel() {

    private val _resultAccount by lazy { MutableLiveData<BaseResponse<LoginResponse>>() }
    val resultAccount: LiveData<BaseResponse<LoginResponse>> = _resultAccount

    private val _resultTransaction by lazy { MutableLiveData<BaseResponse<TransactionHeaderResponse>>() }
    val resultTransaction: LiveData<BaseResponse<TransactionHeaderResponse>> = _resultTransaction

    private val _resultProductsList by lazy { MutableLiveData<BaseResponse<List<ProductsResponse>>>() }
    val resultProductsList: LiveData<BaseResponse<List<ProductsResponse>>> = _resultProductsList

    fun getUserAccount() {
        viewModelScope.launch {
            val response = repository.getUserAccount()
            if (response.isSuccessful) {
                _resultAccount.postValue(response.body())
            } else {
                _resultAccount.postValue(null)
            }
        }
    }

    fun getProductsList() {
        viewModelScope.launch {
            val response = repository.getListProducts()
            if (response.isSuccessful) {
                _resultProductsList.postValue(response.body())
            } else {
                _resultProductsList.postValue(null)
            }
        }
    }

    fun postTransaction(transactionRequest: TransactionHeaderResponse) {
        viewModelScope.launch {
            val response = repository.postTransaction(transactionRequest)
            if (response.isSuccessful) {
                _resultTransaction.postValue(response.body())
            } else {
                _resultTransaction.postValue(null)
            }
        }
    }
}