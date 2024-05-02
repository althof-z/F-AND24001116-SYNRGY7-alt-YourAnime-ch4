package com.example.chapter_4_challenge.ui.fragments.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.chapter_4_challenge.ui.fragments.data.Anime

class AnimeDiffUtil : DiffUtil.ItemCallback<Anime>() {

    override fun areItemsTheSame(oldItem: Anime, newItem: Anime): Boolean {
        return oldItem.title == newItem.title
    }

    override fun areContentsTheSame(oldItem: Anime, newItem: Anime): Boolean {
        return oldItem.title == newItem.title
    }
}