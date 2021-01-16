package com.burhan.common.data.remote.datasource

import com.burhan.common.data.remote.model.BitCoinDTO
import com.burhan.common.data.repository.Result

interface IRemoteDataSource {
    suspend fun downloadBitCoinPrice(): Result<BitCoinDTO>
}