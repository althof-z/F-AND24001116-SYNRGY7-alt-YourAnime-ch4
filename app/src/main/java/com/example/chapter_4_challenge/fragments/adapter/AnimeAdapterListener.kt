package com.example.chapter_4_challenge.fragments.adapter

import com.example.chapter_4_challenge.fragments.data.Anime

interface AnimeAdapterListener {

    fun onClickAnime(data: Anime)
}