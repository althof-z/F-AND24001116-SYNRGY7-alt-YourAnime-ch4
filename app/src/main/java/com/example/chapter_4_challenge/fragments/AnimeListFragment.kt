package com.example.chapter_4_challenge.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chapter_4_challenge.R
import com.example.chapter_4_challenge.databinding.FragmentAnimeListBinding
import com.example.chapter_4_challenge.fragments.adapter.AnimeAdapter
import com.example.chapter_4_challenge.fragments.adapter.AnimeAdapterListener
import com.example.chapter_4_challenge.fragments.data.Anime


class AnimeListFragment : Fragment(), AnimeAdapterListener {
    private lateinit var binding: FragmentAnimeListBinding
    private lateinit var genre: String
    private var isGridLayout = false
    private val animeAdapter = AnimeAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        genre = AnimeListFragmentArgs.fromBundle(requireArguments()).currentGenre
        binding = FragmentAnimeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAnimeRV()
        setHasOptionsMenu(true)

        (activity as AppCompatActivity).supportActionBar?.title = "Anime List: $genre"
    }

    private fun setupAnimeRV(){
        binding.rvAnimeList.apply {
            adapter = animeAdapter
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            itemAnimator = DefaultItemAnimator()
        }
        animeAdapter.submitList(getAnimeOfGenre())
    }

    private fun getAnimeOfGenre(): List<Anime> {
        return when (genre) {
            "Action" -> listOf(
                Anime("Shingeki no Kyojin"),
                Anime("My Hero Academia"),
                Anime("One Punch Man"),
                Anime("Attack on Titan"),
                Anime("Demon Slayer")
            )
            "Fantasy" -> listOf(
                Anime("Sword Art Online"),
                Anime("Fairy Tail"),
                Anime("No Game No Life"),
                Anime("Overlord"),
                Anime("Re:Zero")
            )
            "Adventure" -> listOf(
                Anime("One Piece"),
                Anime("Naruto"),
                Anime("Hunter x Hunter"),
                Anime("Fairy Tail"),
                Anime("Dragon Ball")
            )
            "Sports" -> listOf(
                Anime("Haikyuu!!"),
                Anime("Kuroko no Basket"),
                Anime("Yuri on Ice"),
                Anime("Free!"),
                Anime("Ace of Diamond")
            )
            "Drama" -> listOf(
                Anime("Your Lie in April"),
                Anime("Clannad"),
                Anime("Anohana"),
                Anime("A Silent Voice"),
                Anime("Erased")
            )
            "Slice of Life" -> listOf(
                Anime("Barakamon"),
                Anime("Usagi Drop"),
                Anime("March Comes in Like a Lion"),
                Anime("K-On!"),
                Anime("Silver Spoon")
            )
            "Romance" -> listOf(
                Anime("Toradora!"),
                Anime("Kimi ni Todoke"),
                Anime("Lovely★Complex"),
                Anime("Your Name"),
                Anime("Golden Time")
            )
            "Music" -> listOf(
                Anime("K-On!"),
                Anime("Beck"),
                Anime("Nodame Cantabile"),
                Anime("Given"),
                Anime("Sound! Euphonium")
            )
            "Horror" -> listOf(
                Anime("Another"),
                Anime("Tokyo Ghoul"),
                Anime("Parasyte"),
                Anime("Corpse Party"),
                Anime("Higurashi: When They Cry")
            )
            "Thriller" -> listOf(
                Anime("Death Note"),
                Anime("Monster"),
                Anime("Psycho-Pass"),
                Anime("Steins;Gate"),
                Anime("Serial Experiments Lain")
            )
            else -> emptyList()
        }
    }




    private fun searchAnime(data: Anime) {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            setData(Uri.parse("https://www.google.com/search?q=${data.title}"))
        }
        startActivity(intent)
    }

    override fun onClickAnime(data: Anime) {
        searchAnime(data)
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

}