package com.example.chapter_4_challenge.fragments.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.chapter_4_challenge.databinding.ItemGenreBinding
import com.example.chapter_4_challenge.fragments.adapter.GenreAdapterListener
import com.example.chapter_4_challenge.fragments.data.Genre

class GenreViewHolder(
    private val itemViewBinding: ItemGenreBinding,
    private val genreAdapterListener: GenreAdapterListener

):RecyclerView.ViewHolder(itemViewBinding.root) {

    fun bindGenre(data: Genre){
        itemViewBinding.tvGenreTitle.text = data.title

        itemViewBinding.root.setOnClickListener{
            genreAdapterListener.onClickMovie(data)
        }
    }
}