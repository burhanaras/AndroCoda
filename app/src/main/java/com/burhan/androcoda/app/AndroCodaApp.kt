package com.burhan.androcoda.app

import android.app.Application
import com.burhan.common.data.local.database.AppDatabase
import com.burhan.common.data.local.datasource.LocalDataSource
import com.burhan.common.data.remote.api.ApiFactory
import com.burhan.common.data.remote.datasource.RemoteDataSource
import com.burhan.common.data.repository.IRepository
import com.burhan.common.data.repository.Repository

class AndroCodaApp : Application() {

    lateinit var repository: IRepository
        private set

    override fun onCreate() {
        super.onCreate()
        instance = this

        initDatabase()
    }

    private fun initDatabase() {
        val remoteDataSource = RemoteDataSource(ApiFactory.apiService)
        val dao = AppDatabase.getInstance(this).dao()
        val localDataSource = LocalDataSource(dao)
        repository = Repository(remoteDataSource, localDataSource)
    }

    companion object {
        lateinit var instance: AndroCodaApp
            private set
    }
}