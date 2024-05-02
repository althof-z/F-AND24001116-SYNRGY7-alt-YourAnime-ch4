package com.example.chapter_4_challenge.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.chapter_4_challenge.data.datasource.AnimeLocalData
import com.example.chapter_4_challenge.data.datasource.AnimeRemoteData
import com.example.chapter_4_challenge.data.datasource.local.AnimeLocalDataImpl
import com.example.chapter_4_challenge.data.datasource.remote.AnimeRemoteDataImpl
import com.example.chapter_4_challenge.data.repository.AnimeRepositoryImpl
import com.example.chapter_4_challenge.domain.AnimeRepository
import com.example.chapter_4_challenge.ui.fragments.data.Anime

class AnimeFragmentViewModel(
    private val repository: AnimeRepository,
) : ViewModel() {

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val localData: AnimeLocalData = AnimeLocalDataImpl()
                val remoteData: AnimeRemoteData = AnimeRemoteDataImpl()
                val myRepository: AnimeRepository = AnimeRepositoryImpl(
                    remoteData = remoteData,
                    localData = localData,
                )
                AnimeFragmentViewModel(repository = myRepository)
            }
        }
    }

    private val _animes: MutableLiveData<List<Anime>> = MutableLiveData()
    val animes: LiveData<List<Anime>> = _animes

    fun retrieveAvailableAnimes(){
        _animes.value = repository.fetchData()
    }
}