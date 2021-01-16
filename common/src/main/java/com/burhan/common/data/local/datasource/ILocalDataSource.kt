package com.burhan.common.data.local.datasource

import com.burhan.common.data.local.entity.BitCoinEntity
import com.burhan.common.data.repository.Result

interface ILocalDataSource {
    suspend fun save(bitCoinEntity: BitCoinEntity)
    suspend fun getAll(): Result<List<BitCoinEntity>>
}