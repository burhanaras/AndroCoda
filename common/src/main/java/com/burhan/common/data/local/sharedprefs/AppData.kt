package com.burhan.common.data.local.sharedprefs

import android.content.Context

class AppData(private val context: Context) {

    var showWalkThrough: Boolean by PreferenceExtension(context, "showWalkThrough", true)

    companion object {
        var userInfo: String = ""
    }
}