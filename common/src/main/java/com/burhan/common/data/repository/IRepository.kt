package com.burhan.common.data.repository

import com.burhan.common.data.local.datasource.model.BitCoinEntity
import com.burhan.common.data.remote.model.BitCoinDTO

interface IRepository {
    suspend fun downloadBitCoinPrice(): Result<BitCoinDTO>
    suspend fun saveBitCoinPrice(bitCoinEntity: BitCoinEntity)
}