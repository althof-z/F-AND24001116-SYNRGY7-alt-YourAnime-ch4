package com.example.chapter_3_challenge.fragments

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chapter_3_challenge.databinding.FragmentAnimeListBinding
import com.example.chapter_3_challenge.fragments.adapter.AnimeAdapter
import com.example.chapter_3_challenge.fragments.adapter.AnimeAdapterListener
import com.example.chapter_3_challenge.fragments.data.Anime


class AnimeListFragment : Fragment(), AnimeAdapterListener {
    private lateinit var binding: FragmentAnimeListBinding
    private lateinit var genre: String
    private val animeAdapter = AnimeAdapter(this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        genre = AnimeListFragmentArgs.fromBundle(requireArguments()).currentGenre
        return FragmentAnimeListBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAnimeRV(view.context)
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


    private fun setupAnimeRV(context: Context){
        binding.rvAnimeList.apply {
            adapter = animeAdapter
            layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
            itemAnimator = DefaultItemAnimator()
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


}