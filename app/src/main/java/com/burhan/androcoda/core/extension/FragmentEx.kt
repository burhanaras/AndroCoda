package com.burhan.androcoda.core.extension

import android.app.Activity
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import com.burhan.androcoda.app.AndroCodaApp
import com.burhan.androcoda.core.viewmodelfactory.ViewModelFactory

fun Fragment.getViewModelFactory(): ViewModelFactory {
    val repository = (requireContext().applicationContext as AndroCodaApp).repository
    return ViewModelFactory(repository)
}

fun Activity.getViewModelFactory(): ViewModelFactory {
    val repository = (applicationContext as AndroCodaApp).repository
    return ViewModelFactory(repository)
}