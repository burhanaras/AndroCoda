package com.burhan.androcoda.ui

import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.work.*
import com.burhan.androcoda.app.AndroCodaApp
import com.burhan.androcoda.worker.DailyWorker
import java.util.concurrent.TimeUnit

class MainViewModel(app: AndroCodaApp) : AndroidViewModel(app) {

    private val dailyWorker = WorkManager.getInstance(app)

    fun loadData(){
        startDailyWorkManager()
    }

    private fun startDailyWorkManager() {
        Log.d(TAG, "startDailyWorkManager() called")
        val constraints =
            Constraints.Builder().setRequiredNetworkType(NetworkType.CONNECTED).build()

        val workRequestPeriodic = PeriodicWorkRequestBuilder<DailyWorker>(1, TimeUnit.DAYS)
            .setConstraints(constraints)
            .addTag(TAG)
            .build()

        dailyWorker.enqueueUniquePeriodicWork(
            UNIQUE_NAME_DAILY_WORKER,
            ExistingPeriodicWorkPolicy.REPLACE,
            workRequestPeriodic
        )
    }

    companion object {
        private const val UNIQUE_NAME_DAILY_WORKER = "AndroCodaDailyWorkManagerUniqueName"
        private const val TAG = "AndroCodaWorkerTag"
    }
}