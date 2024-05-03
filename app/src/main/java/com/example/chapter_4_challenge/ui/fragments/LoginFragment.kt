package com.example.chapter_4_challenge.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.chapter_4_challenge.R
import com.example.chapter_4_challenge.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    private lateinit var viewBinding: FragmentLoginBinding
    private val viewModel by viewModels<LoginViewModel>{
        LoginViewModel.provideFactory(this, requireContext())
    }
    

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return FragmentLoginBinding.inflate(layoutInflater, container, false).also {
            viewBinding = it
        }.root
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.btnLogin.setOnClickListener {
            if (viewBinding.edtEmailLogin.text.isNullOrEmpty()) {
                viewBinding.edtEmailLogin.error = "email tidak boleh kosong"
            } else if (viewBinding.edtPwLogin.text.isNullOrEmpty()) {
                viewBinding.edtPwLogin.error = "password tidak boleh kosong"
            } else {
                viewBinding.edtEmailLogin.error = null
                viewBinding.edtPwLogin.error = null
                viewModel.login(
                    username = viewBinding.edtEmailLogin.text.toString(),
                    password = viewBinding.edtPwLogin.text.toString(),
                )
            }
        }

//        viewModel.loading.observe(this) { isLoading ->
//            if (isLoading) {
//                viewBinding.flipperButtonLogin.displayedChild = 1
//            } else {
//                viewBinding.flipperButtonLogin.displayedChild = 0
//            }
//        }
//
        viewModel.success.observe(viewLifecycleOwner) { isSuccess ->
            if (isSuccess) {
                Toast.makeText(context, "Login Berhasil!", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_loginFragment_to_animeFragment)
            }
        }
//
        viewModel.error.observe(viewLifecycleOwner) { throwable ->
            Toast.makeText(context, throwable.message, Toast.LENGTH_SHORT).show()
        }

    }


}