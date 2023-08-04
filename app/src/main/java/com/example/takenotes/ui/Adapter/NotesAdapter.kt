package com.example.takenotes.ui.Adapter

import android.R
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.takenotes.Model.Notes
import com.example.takenotes.ViewModel.NotesViewModel
import com.example.takenotes.databinding.HomeRvItemBinding


class NotesAdapter(
    val requireContext: Context,
    val notesList: List<Notes>,
    val viewModel: NotesViewModel
) :
    RecyclerView.Adapter<NotesAdapter.notesViewHolder>() {


    class notesViewHolder(val binding: HomeRvItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): notesViewHolder {
        return notesViewHolder(
            HomeRvItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = notesList.size

    override fun onBindViewHolder(holder: notesViewHolder, position: Int) {
        val Data = notesList[position]
        holder.binding.notesRVTitle.text = Data.title
        holder.binding.notesRVNotes.text = Data.notes
        holder.binding.notesRVDate.text = Data.date

        holder.binding.notesRVDots.setOnClickListener {
            val Data = notesList[position]
            val title = Data.title
            val id1 = Data.Id

            val alertDialog: AlertDialog? = requireContext?.let {
                val builder = AlertDialog.Builder(it)
                builder.setMessage("Do you want to delete Note : $title ?")

                builder.apply {
                    setPositiveButton("Yes",
                        DialogInterface.OnClickListener { dialog, id ->
                            if (id1 != null) {
                                viewModel.deleteNotes(id1)
                            }
                            Toast.makeText(context, "Note deleted Sucessfully", Toast.LENGTH_SHORT);
                        })
                    setNegativeButton("No",
                        DialogInterface.OnClickListener { dialog, id ->

                        })
                }

                // Create the AlertDialog
                builder.create()
            }
            alertDialog?.show()
        }


        holder.binding.root.setOnClickListener {
            var data = notesList[position]

            val args = Bundle()
            args.putString("id", data.Id.toString())
            args.putString("title", data.title)
            args.putString("notes", data.notes)
            args.putString("date", data.date)

            Navigation.findNavController(it)
                .navigate(com.example.takenotes.R.id.action_fragmnt_Home_to_editNotesFragment, args)
        }

    }
}