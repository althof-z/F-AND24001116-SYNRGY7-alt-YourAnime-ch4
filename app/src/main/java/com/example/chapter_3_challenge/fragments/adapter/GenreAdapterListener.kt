package com.example.chapter_3_challenge.fragments.adapter

import com.example.chapter_3_challenge.fragments.data.Genre

interface GenreAdapterListener {

    fun onClickMovie(data: Genre)
}