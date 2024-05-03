package com.example.chapter_4_challenge.data.datasource

import com.example.chapter_4_challenge.data.datasource.local.room.AnimeEntity

interface AnimeLocalData {
     suspend fun insertAnime(animeEntity: AnimeEntity)

    suspend fun deleteAnime(animeEntity: AnimeEntity)

    suspend fun selectAnimeById(id: Int): AnimeEntity?

    suspend fun selectAllAnimes(): List<AnimeEntity>
}