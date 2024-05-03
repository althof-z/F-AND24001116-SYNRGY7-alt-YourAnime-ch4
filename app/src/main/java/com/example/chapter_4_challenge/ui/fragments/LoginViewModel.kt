package com.example.chapter_4_challenge.ui.fragments

import android.content.Context
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.savedstate.SavedStateRegistryOwner
import com.example.chapter_4_challenge.data.datasource.local.AuthLocalDataImpl
import com.example.chapter_4_challenge.data.datasource.local.SharedPreferencesFactory
import com.example.chapter_4_challenge.data.datasource.remote.AuthRemoteDataImpl
import com.example.chapter_4_challenge.data.repository.AuthRepositoryImpl
import com.example.chapter_4_challenge.domain.AuthRepository
import kotlinx.coroutines.launch

class LoginViewModel(
    private val authRepository: AuthRepository,
) : ViewModel() {

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
                            sharedPreferences = SharedPreferencesFactory().createSharedPreferences(context),
                        ),
                        authRemoteData = AuthRemoteDataImpl(),
                    )
                    return LoginViewModel(authRepository = authRepository) as T
                }
            }
    }

    private val _loading = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean> = _loading

    private val _success = MutableLiveData<Boolean>()
    val success: LiveData<Boolean> = _success

    private val _error = MutableLiveData<Throwable>()
    val error: LiveData<Throwable> = _error

    fun login(username: String, password: String) {
        viewModelScope.launch {
            try {
                val token = authRepository.login(username, password)
                authRepository.saveToken(token)
                _success.value = true
            } catch (throwable: Throwable) {
                _error.value = throwable
            }
        }
    }
}