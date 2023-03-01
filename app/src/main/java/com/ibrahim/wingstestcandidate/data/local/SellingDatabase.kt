package com.ibrahim.wingstestcandidate.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(
    entities = [LoginEntity::class, ProductEntity::class, TransactionHeaderEntity::class, TransactionDetailEntity::class],
    version = 2,
    exportSchema = true
)
abstract class SellingDatabase : RoomDatabase() {

    abstract fun sellingDao(): SellingDao

    companion object {
        @Volatile
        private var INSTANCE: SellingDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): SellingDatabase {
            if (INSTANCE == null) {
                synchronized(SellingDatabase::class.java) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        SellingDatabase::class.java, "penjualan_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE as SellingDatabase
        }
    }
}