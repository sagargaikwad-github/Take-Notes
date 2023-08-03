package com.example.takenotes.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.takenotes.R
import com.example.takenotes.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        binding.addNoteBTN.setOnClickListener{
            Navigation.findNavController(it).navigate(R.id.action_fragmnt_Home_to_fragment_createNote)
        }

        return binding.root
    }

}