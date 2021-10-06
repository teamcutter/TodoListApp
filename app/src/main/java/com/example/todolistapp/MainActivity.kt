package com.example.todolistapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.todolistapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    val name = intent.getStringExtra("EXTRA_NAME")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}