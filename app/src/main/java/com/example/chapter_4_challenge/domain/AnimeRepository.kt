package com.example.chapter_4_challenge.domain

import com.example.chapter_4_challenge.ui.fragments.data.Anime

interface AnimeRepository {

    fun fetchData(): List<Anime>

    fun storeData(data: Anime)

    suspend fun storeFavorite(anime: Anime)

    suspend fun getAllAnime(): List<Anime>

    suspend fun deleteAnime(anime: Anime)

    suspend fun getMovieById(id: Int): Anime?
}