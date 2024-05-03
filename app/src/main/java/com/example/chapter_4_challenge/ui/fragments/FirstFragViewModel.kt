package com.example.chapter_4_challenge.ui.fragments

import android.content.Context
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.example.chapter_4_challenge.data.datasource.local.AuthLocalDataImpl
import com.example.chapter_4_challenge.data.datasource.local.SharedPreferencesFactory
import com.example.chapter_4_challenge.data.datasource.remote.AuthRemoteDataImpl
import com.example.chapter_4_challenge.data.repository.AuthRepositoryImpl
import com.example.chapter_4_challenge.domain.AuthRepository

class FirstFragViewModel ( private val authRepository: AuthRepository
): ViewModel() {
    companion object {
        fun provideFactory(
            owner: SavedStateRegistryOwner,
            context: Context,
        ): AbstractSavedStateViewModelFactory =
            object : AbstractSavedStateViewModelFactory(owner, null) {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(
                    key: String,
                    modelClass: Class<T>,
                    handle: SavedStateHandle,
                ): T {
                    val authRepository: AuthRepository = AuthRepositoryImpl(
                        authLocalData = AuthLocalDataImpl(
                            sharedPreferences = SharedPreferencesFactory().createSharedPreferences(
                                context
                            ),
                        ),
                        authRemoteData = AuthRemoteDataImpl(),
                    )
                    return FirstFragViewModel(authRepository = authRepository) as T
                }
            }
    }

    fun checkLogin(): Boolean {
        return !authRepository.loadToken().isNullOrEmpty()
    }
}