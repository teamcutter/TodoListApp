package com.example.todolistapp.note

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.todolistapp.databinding.FragmentNoteBinding
import com.example.todolistapp.home.HomeFragment

class NoteFragment : Fragment() {

    lateinit var binding: FragmentNoteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNoteBinding.inflate(layoutInflater)
        return binding.root
    }

    // реализация синглтона
    companion object{
        @JvmStatic
        fun newInstance() : NoteFragment = NoteFragment()
    }

}