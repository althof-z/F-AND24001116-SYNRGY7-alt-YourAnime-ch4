package com.example.chapter_4_challenge.data.datasource.remote

import com.example.chapter_4_challenge.data.datasource.AnimeRemoteData
import com.example.chapter_4_challenge.ui.fragments.data.Anime

class AnimeRemoteDataImpl: AnimeRemoteData {
    override fun fetchData(): List<Anime> {
        return listOf(
            Anime(id = 1, title = "Shingeki no Kyojin"),
            Anime(id = 2, title = "My Hero Academia"),
            Anime(id = 3, title = "One Punch Man"),
            Anime(id = 4, title = "Attack on Titan"),
            Anime(id = 5, title = "Sword Art Online"),
            Anime(id = 6, title = "Fairy Tail"),
            Anime(id = 7, title = "No Game No Life"),
            Anime(id = 8, title = "Overlord"),
            Anime(id = 9, title = "One Piece"),
            Anime(id = 10, title = "Naruto"),
            Anime(id = 11, title = "Hunter x Hunter"),
            Anime(id = 12, title = "Fairy Tail"),
        )
    }
}