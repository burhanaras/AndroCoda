package com.burhan.androcoda.app

import android.app.Application
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
        repository = Repository()
    }

    companion object {
        lateinit var instance: AndroCodaApp
            private set
    }
}