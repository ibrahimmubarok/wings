package com.ibrahim.wingstestcandidate.presentation.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.ibrahim.wingstestcandidate.data.local.LoginEntity
import com.ibrahim.wingstestcandidate.data.local.ProductEntity
import com.ibrahim.wingstestcandidate.data.local.TransactionDetailEntity
import com.ibrahim.wingstestcandidate.data.local.TransactionHeaderEntity
import com.ibrahim.wingstestcandidate.data.repository.SellingRepository
import kotlinx.coroutines.launch

class SellingViewModel(private val sellingRepository: SellingRepository): ViewModel() {

    init {
        insertAllData()
    }

    fun getLogin(user: String): LiveData<LoginEntity> = sellingRepository.getLogin(user)
    fun getAllProducts(): LiveData<List<ProductEntity>> = sellingRepository.getAllProducts()
    fun getAllTransactionDetail(): LiveData<List<TransactionDetailEntity>> = sellingRepository.getAllTransactionDetail()

    fun insertTransactionDetail(transaction: TransactionDetailEntity) = viewModelScope.launch {
        sellingRepository.insertTransactionDetail(transaction)
    }

    fun insertTransactionHeader(transaction: TransactionHeaderEntity) = viewModelScope.launch {
        sellingRepository.insertTransactionHeader(transaction)
    }

    private fun insertAllData() = viewModelScope.launch {
        sellingRepository.insertAllData()
    }
}

class ViewModelFactory(private val repository: SellingRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SellingViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SellingViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}