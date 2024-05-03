package com.example.chapter_4_challenge.data.datasource.local

import android.content.Context
import android.content.SharedPreferences

class SharedPreferencesFactory {

    companion object {
        const val SHARED_PREFERENCES_NAME = "SHARED PREFERENCES"
    }

    fun createSharedPreferences(context: Context): SharedPreferences {
        return context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)
    }
}