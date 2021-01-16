package com.burhan.common.data.local.datasource

import com.burhan.common.data.local.database.DAO
import com.burhan.common.data.local.entity.BitCoinEntity
import com.burhan.common.data.repository.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class LocalDataSource(
    private val dao: DAO,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) : ILocalDataSource {
    override suspend fun save(bitCoinEntity: BitCoinEntity) = withContext(ioDispatcher) {
        dao.save(bitCoinEntity)
    }


    override suspend fun getAll(): Result<List<BitCoinEntity>> = withContext(ioDispatcher) {
        return@withContext Result.Success(dao.getAll())
    }

}