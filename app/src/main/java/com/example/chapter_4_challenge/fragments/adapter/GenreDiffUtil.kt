package com.example.chapter_4_challenge.fragments.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.chapter_4_challenge.fragments.data.Genre

class GenreDiffUtil: DiffUtil.ItemCallback<Genre>() {

    override fun areItemsTheSame(oldItem: Genre, newItem: Genre): Boolean {
        return oldItem.title == newItem.title
    }
    override fun areContentsTheSame(oldItem: Genre, newItem: Genre): Boolean {
        return oldItem.title == newItem.title
    }
}