package com.example.chapter_4_challenge.ui.fragments.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.chapter_4_challenge.databinding.ItemAnimeNewBinding
import com.example.chapter_4_challenge.ui.fragments.adapter.AnimeAdapterListener
import com.example.chapter_4_challenge.ui.fragments.data.Anime

class AnimeViewHolder (
    private val itemViewBinding: ItemAnimeNewBinding, private val animeAdapterListener: AnimeAdapterListener

): RecyclerView.ViewHolder(itemViewBinding.root) {

    fun bindAnime(data: Anime){
        itemViewBinding.tvAnimeTitle.text = data.title

        itemViewBinding.btnSearchAnime.setOnClickListener{
            animeAdapterListener.onClickSearchButton(data)
        }

        itemViewBinding.btnFavAnime.setOnClickListener{
            animeAdapterListener.onClickFavButton(data)
        }
    }


}