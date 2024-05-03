package com.example.chapter_4_challenge.ui

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.chapter_4_challenge.R
import com.example.chapter_4_challenge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    private val viewBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val viewModel by viewModels<MainActViewModel> {
        MainActViewModel.provideFactory(this, this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(viewBinding.root)
        setupNavigationComponentWithAppBar()



    }

    private fun setupNavigationComponentWithAppBar() {
       val host: NavHostFragment = supportFragmentManager.findFragmentById(R.id.navContainer) as NavHostFragment? ?: return
       setupActionBarWithNavController(host.navController)
   }

    override fun onSupportNavigateUp(): Boolean {
        val host: NavHostFragment = supportFragmentManager.findFragmentById(R.id.navContainer) as NavHostFragment
        return host.navController.navigateUp() || super.onSupportNavigateUp()
    }


}