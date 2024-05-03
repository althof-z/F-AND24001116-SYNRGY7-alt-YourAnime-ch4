package com.example.chapter_4_challenge.ui.fragments

import android.content.Context
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import androidx.savedstate.SavedStateRegistryOwner
import com.example.chapter_4_challenge.data.datasource.AnimeLocalData
import com.example.chapter_4_challenge.data.datasource.AnimeRemoteData
import com.example.chapter_4_challenge.data.datasource.local.AnimeLocalDataImpl
import com.example.chapter_4_challenge.data.datasource.local.AuthLocalDataImpl
import com.example.chapter_4_challenge.data.datasource.local.SharedPreferencesFactory
import com.example.chapter_4_challenge.data.datasource.local.room.AppDatabase
import com.example.chapter_4_challenge.data.datasource.remote.AnimeRemoteDataImpl
import com.example.chapter_4_challenge.data.datasource.remote.AuthRemoteDataImpl
import com.example.chapter_4_challenge.data.repository.AnimeRepositoryImpl
import com.example.chapter_4_challenge.data.repository.AuthRepositoryImpl
import com.example.chapter_4_challenge.domain.AnimeRepository
import com.example.chapter_4_challenge.domain.AuthRepository
import com.example.chapter_4_challenge.ui.fragments.data.Anime
import kotlinx.coroutines.launch

class FavoriteFragmentViewModel(
    private val animeRepository: AnimeRepository,
    private val authRepository: AuthRepository,
): ViewModel(){

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
                    val appDatabase = Room.databaseBuilder(
                        context = context,
                        name = AppDatabase.DATABASE_NAME,
                        klass = AppDatabase :: class.java,
                    ).build()
                    val localData: AnimeLocalData = AnimeLocalDataImpl(
                        animeDao = appDatabase.animeDao(),
                    )
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
                    return FavoriteFragmentViewModel(
                        animeRepository = myRepository,
                        authRepository = authRepository
                    ) as T
                }
            }


    }

    private val _animes: MutableLiveData<List<Anime>> = MutableLiveData()
    val animes: LiveData<List<Anime>> = _animes

    private val _error = MutableLiveData<Throwable>()
    val error: LiveData<Throwable> = _error

    fun getMovieFromLocal(){
        viewModelScope.launch {
            try {
                _animes.value = animeRepository.getAllAnime()
            } catch (throwable: Throwable) {
                _error.value = throwable
            }
        }
    }

    fun deleteAnimeFromFavorite(anime: Anime){
        viewModelScope.launch {
            animeRepository.deleteAnime(anime)
        }
    }

    private val _animeLocal = MutableLiveData<Anime?>()
    fun loadAnimeFromFavorite(id: Int){
        viewModelScope.launch {
            try {
                _animeLocal.value = animeRepository.getMovieById(id)
            } catch (throwable: Throwable){
                _error.value = throwable
            }
        }
    }
    fun logout() {
        authRepository.clearToken()
    }


}