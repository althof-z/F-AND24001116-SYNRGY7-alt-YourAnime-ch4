package com.example.chapter_4_challenge.data.datasource.mapper

import com.example.chapter_4_challenge.data.datasource.local.room.AnimeEntity
import com.example.chapter_4_challenge.ui.fragments.data.Anime

fun Anime.toAnimeEntity(): AnimeEntity{
    return AnimeEntity(
        id = id,
        title = title
    )
}

fun AnimeEntity.toAnime(): Anime{
    return Anime(
        id = id,
        title = title
    )
}

fun List<AnimeEntity>.toAnimes(): List<Anime>{
    return map { animeEntity -> animeEntity.toAnime() }
}