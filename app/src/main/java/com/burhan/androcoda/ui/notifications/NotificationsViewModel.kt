package com.burhan.androcoda.ui.notifications

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NotificationsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "AndroCoda : The best architecture for an Android app"
    }
    val text: LiveData<String> = _text
}