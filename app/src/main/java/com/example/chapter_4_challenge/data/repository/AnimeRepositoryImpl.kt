package com.example.chapter_4_challenge.data.repository

import com.example.chapter_4_challenge.data.datasource.AnimeLocalData
import com.example.chapter_4_challenge.data.datasource.AnimeRemoteData
import com.example.chapter_4_challenge.domain.AnimeRepository
import com.example.chapter_4_challenge.ui.fragments.data.Anime

class AnimeRepositoryImpl(
    private val remoteData: AnimeRemoteData,
    private val localData: AnimeLocalData,
): AnimeRepository {
    override fun fetchData(): List<Anime> {
        return remoteData.fetchData()
    }

    override fun storeData(data: Anime) {
        TODO("Not yet implemented")
    }
}