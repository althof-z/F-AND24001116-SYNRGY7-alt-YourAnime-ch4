package com.example.chapter_4_challenge.ui.fragments

import android.content.Context
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.example.chapter_4_challenge.data.datasource.AnimeLocalData
import com.example.chapter_4_challenge.data.datasource.AnimeRemoteData
import com.example.chapter_4_challenge.data.datasource.local.AnimeLocalDataImpl
import com.example.chapter_4_challenge.data.datasource.local.AuthLocalDataImpl
import com.example.chapter_4_challenge.data.datasource.local.SharedPreferencesFactory
import com.example.chapter_4_challenge.data.datasource.remote.AnimeRemoteDataImpl
import com.example.chapter_4_challenge.data.datasource.remote.AuthRemoteDataImpl
import com.example.chapter_4_challenge.data.repository.AnimeRepositoryImpl
import com.example.chapter_4_challenge.data.repository.AuthRepositoryImpl
import com.example.chapter_4_challenge.domain.AnimeRepository
import com.example.chapter_4_challenge.domain.AuthRepository
import com.example.chapter_4_challenge.ui.fragments.data.Anime

class AnimeFragmentViewModel(
    private val repository: AnimeRepository,
    private val authRepository: AuthRepository
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
                    val localData: AnimeLocalData = AnimeLocalDataImpl()
                val remoteData: AnimeRemoteData = AnimeRemoteDataImpl()
                val myRepository: AnimeRepository = AnimeRepositoryImpl(
                    remoteData = remoteData,
                    localData = localData,
                )
                    val authRepository: AuthRepository = AuthRepositoryImpl(
                    authLocalData = AuthLocalDataImpl(
                        sharedPreferences = SharedPreferencesFactory().createSharedPreferences(context),
                    ),
                    authRemoteData = AuthRemoteDataImpl(),
                )
                    return AnimeFragmentViewModel(repository = myRepository, authRepository = authRepository) as T
                }
            }


//        val Factory: ViewModelProvider.Factory = viewModelFactory {
//            initializer {
//                val localData: AnimeLocalData = AnimeLocalDataImpl()
//                val remoteData: AnimeRemoteData = AnimeRemoteDataImpl()
//                val myRepository: AnimeRepository = AnimeRepositoryImpl(
//                    remoteData = remoteData,
//                    localData = localData,
//                )
//                val authRepository: AuthRepository = AuthRepositoryImpl(
//                    authLocalData = AuthLocalDataImpl(
//                        sharedPreferences = SharedPreferencesFactory().createSharedPreferences(context),
//                    ),
//                    authRemoteData = AuthRemoteDataImpl(),
//                )
//                AnimeFragmentViewModel(repository = myRepository, authRepository = authRepository)
//            }
//        }
    }

    private val _animes: MutableLiveData<List<Anime>> = MutableLiveData()
    val animes: LiveData<List<Anime>> = _animes

    fun retrieveAvailableAnimes(){
        _animes.value = repository.fetchData()
    }

    fun logout() {
        authRepository.clearToken()
    }
}