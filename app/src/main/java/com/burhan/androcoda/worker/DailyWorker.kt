package com.burhan.androcoda.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters

class DailyWorker(appContext: Context, workerParameters: WorkerParameters) :
    CoroutineWorker(
        appContext, workerParameters
    ) {
    override suspend fun doWork(): Result {
        return Result.success()
    }
}