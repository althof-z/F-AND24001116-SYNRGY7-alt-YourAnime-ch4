package com.example.chapter_4_challenge.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.chapter_4_challenge.R
import com.example.chapter_4_challenge.databinding.FragmentFirstBinding

class  FirstFragment : Fragment() {

    private lateinit var viewBinding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return FragmentFirstBinding.inflate(layoutInflater, container, false).also {
            viewBinding = it
        }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.btnGo.setOnClickListener{
            it.findNavController().navigate(R.id.action_firstFragment_to_animeGenreFragment)

        }

        viewBinding.btnRegister.setOnClickListener {
            it.findNavController().navigate(R.id.action_firstFragment_to_registerFragment)
        }

        viewBinding.btnLogin.setOnClickListener {
            it.findNavController().navigate(R.id.action_firstFragment_to_loginFragment)
        }
    }

}