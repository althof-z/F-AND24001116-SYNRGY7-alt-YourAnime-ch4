package com.example.chapter_4_challenge.data.datasource.remote

import com.example.chapter_4_challenge.data.datasource.AnimeRemoteData
import com.example.chapter_4_challenge.ui.fragments.data.Anime

class AnimeRemoteDataImpl: AnimeRemoteData {
    override fun fetchData(): List<Anime> {
        return listOf(
            Anime("Shingeki no Kyojin"),
            Anime("My Hero Academia"),
            Anime("One Punch Man"),
            Anime("Attack on Titan"),
            Anime("Sword Art Online"),
            Anime("Fairy Tail"),
            Anime("No Game No Life"),
            Anime("Overlord"),
            Anime("One Piece"),
            Anime("Naruto"),
            Anime("Hunter x Hunter"),
            Anime("Fairy Tail"),
        )
    }
}