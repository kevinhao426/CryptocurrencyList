package com.kevinhao426.cryptocurrencylist.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.kevinhao426.cryptocurrencylist.model.CurrencyData

@Database(entities = [CurrencyData::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun currencyDataDao(): CurrencyDataDao
}