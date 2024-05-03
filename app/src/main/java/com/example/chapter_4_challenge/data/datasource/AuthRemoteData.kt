package com.example.chapter_4_challenge.data.datasource

interface AuthRemoteData {
    suspend fun login(username: String, password: String): String
}