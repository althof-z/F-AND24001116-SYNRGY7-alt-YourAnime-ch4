package com.example.chapter_3_challenge.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chapter_3_challenge.databinding.FragmentAnimeGenreBinding
import com.example.chapter_3_challenge.fragments.adapter.GenreAdapter
import com.example.chapter_3_challenge.fragments.adapter.GenreAdapterListener
import com.example.chapter_3_challenge.fragments.data.Anime
import com.example.chapter_3_challenge.fragments.data.Genre

class AnimeGenreFragment : Fragment(), GenreAdapterListener {

    private lateinit var binding: FragmentAnimeGenreBinding
    private val genreAdapter = GenreAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return FragmentAnimeGenreBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupGenreRV(view.context)
    }

    private fun setupGenreRV(context: Context){
        binding.rvAnimeGenre.adapter = genreAdapter

        binding.rvAnimeGenre.layoutManager = LinearLayoutManager(
            context, RecyclerView.VERTICAL, false
        )
        binding.rvAnimeGenre.itemAnimator = DefaultItemAnimator()

        genreAdapter.submitList(retreiveAvailableGenre())
    }

    private fun retreiveAvailableGenre(): List<Genre>{
        return listOf(
            Genre(
                title = "Action",
            ), Genre(
                title = "Fantasy",
            ), Genre(
                title = "Adventure",
            ),Genre(
                title = "Sports",
            ), Genre(
                title = "Drama",
            ),Genre(
                title = "Slice of Life",
            ), Genre(
                title = "Romance",
            ), Genre(
                title = "Music",
            ),Genre(
                title = "Horror",
            ), Genre(
                title = "Thriller",
            ),
        )
    }

    private fun navigateToAnimeList(data: Genre) {
        val actionToAnimeList = AnimeGenreFragmentDirections
            .actionAnimeGenreFragmentToAnimeListFragment()
        actionToAnimeList.currentGenre = data.title
        findNavController().navigate(actionToAnimeList)
    }


    override fun onClickMovie(data: Genre) {
        navigateToAnimeList(data)
    }


}