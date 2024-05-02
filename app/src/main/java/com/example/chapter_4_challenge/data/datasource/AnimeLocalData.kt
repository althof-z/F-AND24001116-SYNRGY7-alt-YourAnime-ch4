package com.example.chapter_4_challenge.data.datasource

import com.example.chapter_4_challenge.ui.fragments.data.Anime

interface AnimeLocalData {

    fun StoreToLocalDB(data: Anime)
}