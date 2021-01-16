package com.burhan.common.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class BitCoinEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val time: Long,
    val usdRate: String,
    val usdCode: String,
    val gbpRate: String,
    val gbpCode: String,
    val eurRate: String,
    val eurCode: String
)