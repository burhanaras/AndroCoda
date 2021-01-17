package com.burhan.common.data.repository

import com.burhan.common.data.local.datasource.ILocalDataSource
import com.burhan.common.data.local.entity.BitCoinEntity
import com.burhan.common.data.remote.datasource.IRemoteDataSource
import com.burhan.common.data.remote.model.BitCoinDTO

class Repository(
    private val remoteDataSource: IRemoteDataSource,
    private val localDataSource: ILocalDataSource
) : IRepository {

    override suspend fun downloadBitCoinPrice(): Result<BitCoinDTO> {
        return remoteDataSource.downloadBitCoinPrice()
    }

    override suspend fun saveBitCoinPrice(bitCoinEntity: BitCoinEntity) {
        localDataSource.save(bitCoinEntity)
    }
}