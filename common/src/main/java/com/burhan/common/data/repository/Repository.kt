package com.burhan.common.data.repository

import com.burhan.common.data.local.datasource.model.BitCoinEntity
import com.burhan.common.data.remote.model.BitCoinDTO

class Repository: IRepository {
    override suspend fun downloadBitCoinPrice(): Result<BitCoinDTO> {
        TODO("Not yet implemented")
    }

    override suspend fun saveBitCoinPrice(bitCoinEntity: BitCoinEntity) {
        TODO("Not yet implemented")
    }
}