package com.example.chapter_4_challenge.data.repository

import com.example.chapter_4_challenge.data.datasource.AnimeLocalData
import com.example.chapter_4_challenge.data.datasource.AnimeRemoteData
import com.example.chapter_4_challenge.data.datasource.mapper.toAnime
import com.example.chapter_4_challenge.data.datasource.mapper.toAnimeEntity
import com.example.chapter_4_challenge.data.datasource.mapper.toAnimes
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
    }

    override suspend fun storeFavorite(anime: Anime) {
        localData.insertAnime(anime.toAnimeEntity())
    }

    override suspend fun deleteAnime(anime: Anime) {
        localData.deleteAnime(anime.toAnimeEntity())
    }

    override suspend fun getAllAnime(): List<Anime> {
        return localData.selectAllAnimes().toAnimes()
    }

    override suspend fun getMovieById(id: Int): Anime? {
        return localData.selectAnimeById(id)?.toAnime()
    }
}