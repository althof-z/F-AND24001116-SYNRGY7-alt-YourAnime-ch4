package com.example.chapter_4_challenge.data.datasource.local

import android.content.SharedPreferences
import com.example.chapter_4_challenge.data.datasource.AuthLocalData

class AuthLocalDataImpl(
    private val sharedPreferences: SharedPreferences,
) : AuthLocalData {

    companion object {
        const val KEY_TOKEN = "TOKEN"
    }

    override fun saveToken(token: String) {
        sharedPreferences.edit().putString(KEY_TOKEN, token).apply()
    }

    override fun loadToken(): String? {
        return sharedPreferences.getString(KEY_TOKEN, null)
    }

    override fun clearToken() {
        sharedPreferences.edit().remove(KEY_TOKEN).apply()
    }
}