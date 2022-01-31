package com.kevinhao426.cryptocurrencylist.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.kevinhao426.cryptocurrencylist.model.CurrencyData

@Database(entities = [CurrencyData::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun currencyDataDao(): CurrencyDataDao

    companion object {
        //singleton with synchronized lock can prevent multiple instance of db opening at the same time
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDataBase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "CurrencyDemoDB"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}