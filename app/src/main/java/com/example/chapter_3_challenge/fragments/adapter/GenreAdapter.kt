package com.example.chapter_3_challenge.fragments.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.chapter_3_challenge.databinding.ItemGenreBinding
import com.example.chapter_3_challenge.fragments.data.Genre
import com.example.chapter_3_challenge.fragments.viewholder.GenreViewHolder

class GenreAdapter(private val genreAdapterListener: GenreAdapterListener)
    : ListAdapter<Genre, GenreViewHolder>(GenreDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder {
        return GenreViewHolder(
            itemViewBinding = ItemGenreBinding.inflate(
                LayoutInflater.from(parent.context), parent, false,
            ),
            genreAdapterListener = genreAdapterListener,
        )
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        holder.bindGenre(getItem(position))
    }
}