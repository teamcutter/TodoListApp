package com.example.todolistapp

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import com.example.todolistapp.databinding.ActivityLogInBinding

class LogInActivity : AppCompatActivity() {
    lateinit var binding: ActivityLogInBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)

        binding.logInBtn.setOnClickListener {
            if(binding.logInEdt.text.toString().isNotEmpty()) {
                    Intent(this, MainActivity::class.java).also {
                        it.putExtra("EXTRA_NAME", binding.logInEdt.text.toString())
                        startActivity(it)
                        finish()
                    }
            } else {
                Toast.makeText(this, "Wrong!", Toast.LENGTH_LONG).show()
            }
        }

        setContentView(binding.root)
    }
}