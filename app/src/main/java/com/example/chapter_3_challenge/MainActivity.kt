package com.example.chapter_3_challenge

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.chapter_3_challenge.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    companion object{
        fun startActivity(context: Context){
            context.startActivity(Intent(context, MainActivity::class.java))
        }
    }

    private val viewBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }

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