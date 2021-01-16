package com.burhan.common.data.local.database

import androidx.room.*
import com.burhan.common.data.local.entity.BitCoinEntity

@Dao
interface DAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun save(bitCoinEntity: BitCoinEntity)

    @Query("SELECT * from BitCoinEntity")
    suspend fun getAll(): List<BitCoinEntity>

    @Query("SELECT * FROM BitCoinEntity WHERE id = :id LIMIT 1")
    suspend fun get(id: Long): BitCoinEntity?

    @Insert
    suspend fun saveAll(vararg bitCoinEntity: BitCoinEntity)

    @Delete
    suspend fun delete(bitCoinEntity: BitCoinEntity)
}