package com.example.chapter_4_challenge.domain

import com.example.chapter_4_challenge.ui.fragments.data.Anime

interface AnimeRepository {

    fun fetchData(): List<Anime>

    fun storeData(data: Anime)
}