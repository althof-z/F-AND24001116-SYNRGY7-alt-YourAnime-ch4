package com.example.chapter_4_challenge.data.datasource

interface AuthLocalData {
    fun saveToken(token: String)
    fun loadToken(): String?
    fun clearToken()
}