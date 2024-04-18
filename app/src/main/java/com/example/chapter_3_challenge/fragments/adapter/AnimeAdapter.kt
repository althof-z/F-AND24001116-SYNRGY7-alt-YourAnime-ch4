package com.example.chapter_3_challenge.fragments.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.chapter_3_challenge.databinding.ItemAnimeBinding
import com.example.chapter_3_challenge.fragments.data.Anime
import com.example.chapter_3_challenge.fragments.viewholder.AnimeViewHolder

class AnimeAdapter : ListAdapter<Anime, AnimeViewHolder>(AnimeDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        return AnimeViewHolder(
            itemViewBinding = ItemAnimeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false,
            ),
//            movieAdapterListener = movieAdapterListener,
        )
    }

    override fun getItemCount(): Int {
        return currentList.size
    }

    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        holder.bindAnime(getItem(position))
    }
}