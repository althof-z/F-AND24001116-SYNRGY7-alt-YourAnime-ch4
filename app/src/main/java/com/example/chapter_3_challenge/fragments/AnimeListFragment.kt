package com.example.chapter_3_challenge.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chapter_3_challenge.R
import com.example.chapter_3_challenge.databinding.FragmentAnimeListBinding
import com.example.chapter_3_challenge.fragments.adapter.AnimeAdapter
import com.example.chapter_3_challenge.fragments.data.Anime


class AnimeListFragment : Fragment() {
    private lateinit var binding: FragmentAnimeListBinding
    private val animeAdapter = AnimeAdapter()
    private lateinit var genre: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        genre = getGenre()
        // Inflate the layout for this fragment
        return FragmentAnimeListBinding.inflate(inflater, container, false).also { 
            binding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupAnimeRV(view.context)


    }

    private fun getAnimeOfGenre():List<Anime>{

        when (genre) {
            "Action" -> {
                return listOf(
                    Anime("Shingeki no Kyojin"),
                    Anime("My Hero Academia"),
                    Anime("One Punch Man"),
                    Anime("Attack on Titan"),
                    Anime("Demon Slayer")
                )
            }
            "Fantasy" -> {
                return listOf(
                    Anime("Sword Art Online"),
                    Anime("Fairy Tail"),
                    Anime("No Game No Life"),
                    Anime("Overlord"),
                    Anime("Re:Zero")
                )
            }
            "Adventure" -> {
                return listOf(
                    Anime("One Piece"),
                    Anime("Naruto"),
                    Anime("Hunter x Hunter"),
                    Anime("Fairy Tail"),
                    Anime("Dragon Ball")
                )
            }
            "Sports" -> {
                return listOf(
                    Anime("Haikyuu!!"),
                    Anime("Kuroko no Basket"),
                    Anime("Yuri on Ice"),
                    Anime("Free!"),
                    Anime("Ace of Diamond")
                )
            }
            "Drama" -> {
                return listOf(
                    Anime("Your Lie in April"),
                    Anime("Clannad"),
                    Anime("Anohana"),
                    Anime("A Silent Voice"),
                    Anime("Erased")
                )
            }
            "Slice of Life" -> {
                return listOf(
                    Anime("Barakamon"),
                    Anime("Usagi Drop"),
                    Anime("March Comes in Like a Lion"),
                    Anime("K-On!"),
                    Anime("Silver Spoon")
                )
            }
            "Romance" -> {
                return listOf(
                    Anime("Toradora!"),
                    Anime("Kimi ni Todoke"),
                    Anime("Lovely★Complex"),
                    Anime("Your Name"),
                    Anime("Golden Time")
                )
            }
            "Music" -> {
                return listOf(
                    Anime("K-On!"),
                    Anime("Beck"),
                    Anime("Nodame Cantabile"),
                    Anime("Given"),
                    Anime("Sound! Euphonium")
                )
            }
            "Horror" -> {
                return listOf(
                    Anime("Another"),
                    Anime("Tokyo Ghoul"),
                    Anime("Parasyte"),
                    Anime("Corpse Party"),
                    Anime("Higurashi: When They Cry")
                )
            }
            "Thriller" -> {
                return listOf(
                    Anime("Death Note"),
                    Anime("Monster"),
                    Anime("Psycho-Pass"),
                    Anime("Steins;Gate"),
                    Anime("Serial Experiments Lain")
                )
            }
            else -> return listOf()
        }
    }


    private fun setupAnimeRV(context: Context){
        binding.rvAnimeList.adapter = animeAdapter

        binding.rvAnimeList.layoutManager = LinearLayoutManager(
            context, RecyclerView.VERTICAL, false
        )

        binding.rvAnimeList.itemAnimator = DefaultItemAnimator()

        animeAdapter.submitList(getAnimeOfGenre())
    }


    private fun getGenre(): String{
        return getArgs().currentGenre
    }

    private fun getArgs(): AnimeListFragmentArgs{
        return AnimeListFragmentArgs.fromBundle(arguments as Bundle)
    }
    
}