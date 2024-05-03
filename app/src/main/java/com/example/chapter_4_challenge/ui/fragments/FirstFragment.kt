package com.example.chapter_4_challenge.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.example.chapter_4_challenge.R
import com.example.chapter_4_challenge.databinding.FragmentFirstBinding

class  FirstFragment : Fragment() {

    private lateinit var viewBinding: FragmentFirstBinding
    private val viewModel by viewModels<FirstFragViewModel> {
        FirstFragViewModel.provideFactory(this, requireContext())
    }

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

        if (viewModel.checkLogin()) {
            // User is logged in, load MainFragment
            findNavController().navigate(R.id.action_firstFragment_to_animeFragment)
        }

        viewBinding.btnGo.setOnClickListener{
            it.findNavController().navigate(R.id.action_firstFragment_to_animeFragment)

        }

        viewBinding.btnRegister.setOnClickListener {
            it.findNavController().navigate(R.id.action_firstFragment_to_registerFragment)
        }

        viewBinding.btnLogin.setOnClickListener {
            it.findNavController().navigate(R.id.action_firstFragment_to_loginFragment)
        }
    }

}