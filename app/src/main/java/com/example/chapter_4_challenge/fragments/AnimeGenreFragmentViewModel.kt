package com.example.chapter_4_challenge.fragments

import androidx.lifecycle.ViewModel
import com.example.chapter_4_challenge.fragments.data.Genre

class AnimeGenreFragmentViewModel: ViewModel() {

    fun retrieveAvailableGenres(): List<Genre> {
        return listOf(
            Genre("Action"),
            Genre("Fantasy"),
            Genre("Adventure"),
            Genre("Sports"),
            Genre("Drama"),
            Genre("Slice of Life"),
            Genre("Romance"),
            Genre("Music"),
            Genre("Horror"),
            Genre("Thriller")
        )
    }
}