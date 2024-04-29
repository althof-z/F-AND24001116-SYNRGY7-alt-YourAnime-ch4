package com.example.chapter_4_challenge.fragments.adapter

import com.example.chapter_4_challenge.fragments.data.Genre

interface GenreAdapterListener {

    fun onClickMovie(data: Genre)
}