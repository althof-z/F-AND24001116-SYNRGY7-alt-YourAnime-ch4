package com.example.chapter_4_challenge.fragments.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.chapter_4_challenge.databinding.ItemAnimeBinding
import com.example.chapter_4_challenge.fragments.adapter.AnimeAdapterListener
import com.example.chapter_4_challenge.fragments.data.Anime

class AnimeViewHolder (
    private val itemViewBinding: ItemAnimeBinding, private val animeAdapterListener: AnimeAdapterListener

): RecyclerView.ViewHolder(itemViewBinding.root) {

    fun bindAnime(data: Anime){
        itemViewBinding.tvAnimeTitle.text = data.title

        itemViewBinding.root.setOnClickListener{
            animeAdapterListener.onClickAnime(data)
        }
    }


}