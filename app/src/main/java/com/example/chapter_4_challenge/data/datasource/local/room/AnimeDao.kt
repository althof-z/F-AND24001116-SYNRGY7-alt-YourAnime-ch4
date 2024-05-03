package com.example.chapter_4_challenge.data.datasource.local.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AnimeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnime(animeEntity: AnimeEntity)

    @Delete
    suspend fun deleteAnime(animeEntity: AnimeEntity)

    @Query("SELECT * FROM anime WHERE id = :id")
    suspend fun selectAnimeById(id: Int): AnimeEntity?

    @Query("SELECT * FROM anime")
    suspend fun selectAllAnimes(): List<AnimeEntity>
}