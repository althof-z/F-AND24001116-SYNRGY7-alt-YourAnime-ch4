package com.example.chapter_4_challenge.data.repository

import com.example.chapter_4_challenge.data.datasource.AuthLocalData
import com.example.chapter_4_challenge.data.datasource.AuthRemoteData
import com.example.chapter_4_challenge.domain.AuthRepository


class AuthRepositoryImpl(
    private val authLocalData: AuthLocalData,
    private val authRemoteData: AuthRemoteData,
) : AuthRepository {
    override suspend fun login(username: String, password: String): String {
        return authRemoteData.login(username, password)
    }

    override fun saveToken(token: String) {
        authLocalData.saveToken(token)
    }

    override fun loadToken(): String? {
        return authLocalData.loadToken()
    }

    override fun clearToken() {
        authLocalData.clearToken()
    }
}