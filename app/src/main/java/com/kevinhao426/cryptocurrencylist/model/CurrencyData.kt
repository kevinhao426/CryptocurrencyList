package com.kevinhao426.cryptocurrencylist.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class CurrencyData(
    @PrimaryKey
    val id: String,
    @ColumnInfo(name = "name")
    val name: String?,
    @ColumnInfo(name = "symbol")
    val symbol: String?
)