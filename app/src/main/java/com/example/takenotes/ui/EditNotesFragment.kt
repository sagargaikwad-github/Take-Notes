package com.example.takenotes.ui

import android.os.Bundle
import android.text.Editable
import android.text.format.DateFormat
import android.util.Log
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
import com.example.takenotes.databinding.FragmentEditNotesBinding
import java.util.Date

class EditNotesFragment : Fragment() {
    lateinit var binding: FragmentEditNotesBinding
    val viewModel: NotesViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentEditNotesBinding.inflate(layoutInflater, container, false)

        val title = arguments?.getString("title")
        val notes = arguments?.getString("notes")



        binding.editTitle.text = title?.toEditable()
        binding.editNotes.text = notes?.toEditable()


        binding.editSaveBTN.setOnClickListener {
            updateNotes(it)
        }


        return binding.root
    }

    private fun updateNotes(it: View?) {


        val id = arguments?.getString("id")
        val idInt = id?.toInt()
        val getTitle = binding.editTitle.text.toString()
        val getNotes = binding.editNotes.text.toString()

        if(!getTitle.isEmpty())
        {
            val d = Date()
            val s: CharSequence = DateFormat.format("MMMM d,yyyy ", d.time)

            val getDate = s


            val notes = Notes(idInt, getTitle, getNotes, getDate.toString())

            viewModel.updateNotes(notes)
            Toast.makeText(requireContext(), "Notes updated successfully", Toast.LENGTH_LONG).show()

            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.nav_graph, true)
                .build()
            findNavController().navigate(R.id.action_editNotesFragment_to_fragmnt_Home, null, navOptions)

           // Navigation.findNavController(it!!).navigate(R.id.action_editNotesFragment_to_fragmnt_Home)
        }else
        {
            Toast.makeText(requireContext(), "Title cannot be empty", Toast.LENGTH_LONG).show()
        }



    }

    fun String.toEditable(): Editable = Editable.Factory.getInstance().newEditable(this)



}