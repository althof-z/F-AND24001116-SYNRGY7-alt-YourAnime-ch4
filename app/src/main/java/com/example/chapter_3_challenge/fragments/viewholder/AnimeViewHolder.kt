package com.example.chapter_3_challenge.fragments.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.chapter_3_challenge.databinding.ItemAnimeBinding
import com.example.chapter_3_challenge.fragments.data.Anime

class AnimeViewHolder (private val itemViewBinding: ItemAnimeBinding,

): RecyclerView.ViewHolder(itemViewBinding.root) {

    fun bindAnime(data: Anime){
        itemViewBinding.tvAnimeTitle.text = data.title
    }
}