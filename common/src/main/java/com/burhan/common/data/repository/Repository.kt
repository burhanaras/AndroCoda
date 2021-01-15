package com.burhan.common.data.repository

import com.burhan.common.data.local.datasource.model.BitCoinEntity
import com.burhan.common.data.remote.datasource.IDataSource
import com.burhan.common.data.remote.model.BitCoinDTO

class Repository(private val dataSource: IDataSource) : IRepository {

    override suspend fun downloadBitCoinPrice(): Result<BitCoinDTO> {
        return dataSource.downloadBitCoinPrice()
    }

    override suspend fun saveBitCoinPrice(bitCoinEntity: BitCoinEntity) {
        TODO("Not yet implemented")
    }
}