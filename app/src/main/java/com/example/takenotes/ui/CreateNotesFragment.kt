package com.example.takenotes.ui

import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.takenotes.Model.Notes
import com.example.takenotes.R
import com.example.takenotes.ViewModel.NotesViewModel
import com.example.takenotes.databinding.FragmentCreateNotesBinding
import java.util.Date


class CreateNotesFragment : Fragment() {
    lateinit var binding: FragmentCreateNotesBinding

    val viewModel: NotesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCreateNotesBinding.inflate(layoutInflater, container, false)

        binding.ednSaveBTN.setOnClickListener {
            createNotes(it)
        }



        return binding.root
    }

    private fun createNotes(it: View?) {
        val getTitle = binding.ednTitle.text.toString()
        val getNotes = binding.ednNotes.text.toString()

        if(!getTitle.isEmpty())
        {
            val d = Date()
            val s: CharSequence = DateFormat.format("MMMM d,yyyy ", d.time)

            val getDate = s

            val notes = Notes(null, getTitle, getNotes, getDate.toString())

            viewModel.addNotes(notes)
            Toast.makeText(requireContext(), "Notes created successfully", Toast.LENGTH_LONG).show()


            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.nav_graph, true)
                .build()
            findNavController().navigate(R.id.action_fragment_createNote_to_fragmnt_Home, null, navOptions)

           // Navigation.findNavController(it!!).navigate(R.id.action_fragment_createNote_to_fragmnt_Home)

        }else
        {
            Toast.makeText(requireContext(), "Title cannot be empty", Toast.LENGTH_LONG).show()
        }




    }

}