package com.ibrahim.wingstestcandidate.data.repository

import androidx.lifecycle.LiveData
import com.ibrahim.wingstestcandidate.data.InitialDataSource
import com.ibrahim.wingstestcandidate.data.local.*

class SellingRepository(private val sellingDao: SellingDao) {

    fun getLogin(user: String): LiveData<LoginEntity> = sellingDao.getLogin(user)
    fun getAllProducts(): LiveData<List<ProductEntity>> = sellingDao.getAllProducts()
    fun getAllTransactionDetail(): LiveData<List<TransactionDetailEntity>> = sellingDao.getAllTransactionDetail()

    suspend fun insertTransactionHeader(transaction: TransactionHeaderEntity) {
        sellingDao.insertTransactionHeader(transaction)
    }

    suspend fun insertTransactionDetail(transaction: TransactionDetailEntity) {
        sellingDao.insertTransactionDetail(transaction)
    }

    suspend fun insertAllData() {
        sellingDao.insertLogin(InitialDataSource.getLogin())
        sellingDao.insertProduct(InitialDataSource.getProducts())
    }
}