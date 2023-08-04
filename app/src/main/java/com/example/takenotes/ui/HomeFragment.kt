package com.example.takenotes.ui

import android.os.Bundle
import android.os.Handler
import android.os.Parcelable
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
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


        viewModel.getNotes().observe(viewLifecycleOwner, { notesList ->
            binding.rvAllNotes.layoutManager =
                StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
            binding.rvAllNotes.adapter = NotesAdapter(requireContext(), notesList, viewModel)
        })


        binding.addNoteBTN.setOnClickListener {
            Navigation.findNavController(it)
                .navigate(R.id.action_fragmnt_Home_to_fragment_createNote)
        }
        return binding.root
    }


}