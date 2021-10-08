package com.example.todolistapp

import android.os.Bundle
import android.view.Gravity
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.todolistapp.databinding.ActivityMainBinding
import com.example.todolistapp.home.HomeFragment
import com.example.todolistapp.note.NoteFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = intent?.getStringExtra("EXTRA_NAME")

        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, R.string.open, R.string.close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        // to open and close drawer layout
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.navigationView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.menuHomeFragment -> changeFragment(HomeFragment.newInstance())
                R.id.menuNoteFragment -> changeFragment(NoteFragment.newInstance())
            }
            true
        }

    }

    // to respond correctly clicks on toggle button and clicks on menu items
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }


    private fun changeFragment(fragment: Fragment) {
        // http://developer.alexanderklimov.ru/android/theory/fragments.php
        // we don't need to navigate back to previous fragment, so we pass null in addToBackStack()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        binding.drawerLayout.closeDrawer(GravityCompat.START)
        fragmentTransaction.replace(R.id.fragment, fragment)
            .addToBackStack(null)
            .commit()
    }
}