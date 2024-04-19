package com.example.chapter_3_challenge.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chapter_3_challenge.R
import com.example.chapter_3_challenge.databinding.FragmentAnimeGenreBinding
import com.example.chapter_3_challenge.fragments.adapter.GenreAdapter
import com.example.chapter_3_challenge.fragments.adapter.GenreAdapterListener
import com.example.chapter_3_challenge.fragments.data.Genre

class AnimeGenreFragment : Fragment(), GenreAdapterListener {

    private lateinit var binding: FragmentAnimeGenreBinding
    private val genreAdapter = GenreAdapter(this)

    private var isGridLayout = false
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAnimeGenreBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupGenreRV()

        setHasOptionsMenu(true)

    }

    private fun setupGenreRV(){
        binding.rvAnimeGenre.apply {
            adapter = genreAdapter
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            itemAnimator = DefaultItemAnimator()
        }
        genreAdapter.submitList(retrieveAvailableGenres())
    }

    private fun retrieveAvailableGenres(): List<Genre> {
        return listOf(
            Genre("Action"),
            Genre("Fantasy"),
            Genre("Adventure"),
            Genre("Sports"),
            Genre("Drama"),
            Genre("Slice of Life"),
            Genre("Romance"),
            Genre("Music"),
            Genre("Horror"),
            Genre("Thriller")
        )
    }

    private fun navigateToAnimeList(data: Genre) {
        val actionToAnimeList = AnimeGenreFragmentDirections
            .actionAnimeGenreFragmentToAnimeListFragment()
            .setCurrentGenre(data.title)
        findNavController().navigate(actionToAnimeList)
    }


    override fun onClickMovie(data: Genre) {
        navigateToAnimeList(data)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
    }


        override fun onOptionsItemSelected(item: MenuItem): Boolean {
            if (item.itemId == R.id.action_grid) {
                isGridLayout = !isGridLayout
                binding.rvAnimeGenre.layoutManager = if (isGridLayout) {
                    GridLayoutManager(requireContext(), 2)
                } else {
                    LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
                }
                return true
            }
            return super.onOptionsItemSelected(item)
        }




}