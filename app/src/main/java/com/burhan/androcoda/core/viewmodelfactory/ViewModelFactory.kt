package com.burhan.androcoda.core.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.burhan.androcoda.ui.dashboard.DashboardViewModel
import com.burhan.androcoda.ui.home.HomeViewModel
import com.burhan.androcoda.ui.notifications.NotificationsViewModel
import com.burhan.common.domain.usecase.DownloadBitcoinPriceUseCase
import java.lang.Exception

class ViewModelFactory : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        with(modelClass) {
            when {
                isAssignableFrom(HomeViewModel::class.java) -> {
                    HomeViewModel(DownloadBitcoinPriceUseCase())
                }
                isAssignableFrom(DashboardViewModel::class.java) -> {
                    DashboardViewModel()
                }
                isAssignableFrom(NotificationsViewModel::class.java) -> {
                    NotificationsViewModel()
                }
                else -> throw IllegalStateException("You have to define ${modelClass.name} class in ViewModelFactory")
            }
        } as T
}