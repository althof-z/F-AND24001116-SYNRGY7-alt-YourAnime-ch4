package com.example.chapter_4_challenge.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chapter_4_challenge.R
import com.example.chapter_4_challenge.databinding.FragmentAnimeBinding
import com.example.chapter_4_challenge.ui.fragments.adapter.AnimeAdapter
import com.example.chapter_4_challenge.ui.fragments.adapter.AnimeAdapterListener
import com.example.chapter_4_challenge.ui.fragments.data.Anime

class AnimeFragment : Fragment(), AnimeAdapterListener {
    private lateinit var binding: FragmentAnimeBinding
    private var isGridLayout = false
    private val animeAdapter = AnimeAdapter(this)

    private val animeFragmentViewModel by viewModels<AnimeFragmentViewModel> (
        factoryProducer = { AnimeFragmentViewModel.Factory }
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAnimeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAnimeRV()

        setHasOptionsMenu(true)

    }

    private fun setupAnimeRV(){
        binding.rvAnimeList.apply {
            adapter = animeAdapter
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            itemAnimator = DefaultItemAnimator()
        }

        animeFragmentViewModel.retrieveAvailableAnimes()

        animeFragmentViewModel.animes.observe(viewLifecycleOwner){ animes ->
            animeAdapter.submitList(animes)
        }
    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_grid) {
            isGridLayout = !isGridLayout
            binding.rvAnimeList.layoutManager = if (isGridLayout) {
                GridLayoutManager(requireContext(), 2)
            } else {
                LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            }
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onClickAnime(data: Anime) {
        searchAnime(data)
    }

    private fun searchAnime(data: Anime) {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            setData(Uri.parse("https://www.google.com/search?q=${data.title}"))
        }
        startActivity(intent)
    }


}