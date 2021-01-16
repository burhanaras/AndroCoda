package com.burhan.common.data.local.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.burhan.common.data.local.entity.BitCoinEntity

@Database(entities = [BitCoinEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {

    abstract fun dao(): DAO

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context).also { INSTANCE = it }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context, AppDatabase::class.java, "AppDatabase")
                .fallbackToDestructiveMigration()
                .build()
    }
}