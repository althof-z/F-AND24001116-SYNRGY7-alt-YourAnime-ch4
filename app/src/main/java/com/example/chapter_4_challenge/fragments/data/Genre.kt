package com.example.chapter_4_challenge.fragments.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Genre(
    val title: String,
) : Parcelable