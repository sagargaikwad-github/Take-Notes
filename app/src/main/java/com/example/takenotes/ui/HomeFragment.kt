package com.example.takenotes.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.takenotes.R
import com.example.takenotes.ViewModel.NotesViewModel
import com.example.takenotes.databinding.FragmentHomeBinding
import com.example.takenotes.ui.Adapter.NotesAdapter


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    val viewModel: NotesViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        viewModel.getNotes().observe(viewLifecycleOwner, {notesList->
           binding.rvAllNotes.layoutManager=GridLayoutManager(requireContext(),2)
            binding.rvAllNotes.adapter=NotesAdapter(requireContext(),notesList)
        })

        binding.addNoteBTN.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_fragmnt_Home_to_fragment_createNote)
        }

        return binding.root
    }

}