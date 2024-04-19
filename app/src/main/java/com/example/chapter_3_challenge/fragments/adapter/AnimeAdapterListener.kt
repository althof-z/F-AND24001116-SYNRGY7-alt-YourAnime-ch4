package com.example.chapter_3_challenge.fragments.adapter

import com.example.chapter_3_challenge.fragments.data.Anime

interface AnimeAdapterListener {

    fun onClickAnime(data: Anime)
}