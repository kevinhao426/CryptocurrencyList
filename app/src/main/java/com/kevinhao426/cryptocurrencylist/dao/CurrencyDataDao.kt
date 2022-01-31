package com.kevinhao426.cryptocurrencylist.dao

import androidx.room.*
import com.kevinhao426.cryptocurrencylist.model.CurrencyData

@Dao
interface CurrencyDataDao {
    @Query("SELECT * FROM CurrencyData")
    suspend fun getAll(): List<CurrencyData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg data: CurrencyData)

    @Delete
    suspend fun delete(data: CurrencyData)

    @Query("DELETE FROM CurrencyData")
    suspend fun deleteAll()
}