package com.example.todolistapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.todolistapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val name = intent?.getStringExtra("EXTRA_NAME")
        val bundle = Bundle()
        bundle.putString("logName", name)
        val homeFragment = HomeFragment()

        setContentView(binding.root)
        setupActionBarWithNavController(findNavController(R.id.fragment))
    }
}