package com.example.chapter_4_challenge.data.datasource

import com.example.chapter_4_challenge.ui.fragments.data.Anime

interface AnimeRemoteData {

    fun fetchData(): List<Anime>
}