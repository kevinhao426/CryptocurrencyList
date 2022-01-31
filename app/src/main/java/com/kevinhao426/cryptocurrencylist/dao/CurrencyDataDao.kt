package com.kevinhao426.cryptocurrencylist.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.kevinhao426.cryptocurrencylist.model.CurrencyData

@Dao
interface CurrencyDataDao {
    @Query("SELECT * FROM CurrencyData")
    fun getAll(): List<CurrencyData>

    @Insert
    fun insertAll(vararg data: CurrencyData)

    @Delete
    fun delete(data: CurrencyData)
}