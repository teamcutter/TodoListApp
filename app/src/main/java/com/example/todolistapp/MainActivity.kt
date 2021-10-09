package com.example.todolistapp

import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.todolistapp.databinding.ActivityMainBinding
import com.example.todolistapp.home.HomeFragment
import com.example.todolistapp.note.NoteFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolBar)

        navController = findNavController(R.id.fragment)
        /** we use setOf to keep hamburger icon while we changing fragment instead of back-arrow
        in the upper-left corner **/
        appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment, R.id.noteFragment), binding.drawerLayout)

        binding.navigationView.setupWithNavController(navController)
        setupActionBarWithNavController(navController, appBarConfiguration)

    }

    // Ask the NavController to handle "navigate up" events.
    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.fragment).navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    // Close the drawer when hardware back is pressed.
    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}