package com.ibrahim.wingstestcandidate

import android.app.Application
import com.ibrahim.wingstestcandidate.data.local.SellingDatabase
import com.ibrahim.wingstestcandidate.data.repository.SellingRepository

class App : Application() {
    val database by lazy { SellingDatabase.getDatabase(this) }
    val repository by lazy { SellingRepository(database.sellingDao()) }
}