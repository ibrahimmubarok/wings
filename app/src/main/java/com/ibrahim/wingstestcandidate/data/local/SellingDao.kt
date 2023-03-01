package com.ibrahim.wingstestcandidate.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface SellingDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertLogin(login: List<LoginEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertProduct(product: List<ProductEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTransactionHeader(transactionHeader: TransactionHeaderEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertTransactionDetail(transactionDetail: TransactionDetailEntity)

    @Query("SELECT * from login WHERE user = :user")
    fun getLogin(user: String): LiveData<LoginEntity>

    @Query("SELECT * from product")
    fun getAllProducts(): LiveData<List<ProductEntity>>

    @Query("SELECT * from transaction_header")
    fun getAllTransactionHeader(): LiveData<List<TransactionHeaderEntity>>

    @Query("SELECT * from transaction_detail")
    fun getAllTransactionDetail(): LiveData<List<TransactionDetailEntity>>

}