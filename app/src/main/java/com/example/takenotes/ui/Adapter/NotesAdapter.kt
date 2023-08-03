package com.example.takenotes.ui.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.takenotes.Model.Notes
import com.example.takenotes.databinding.HomeRvItemBinding

class NotesAdapter(val requireContext: Context, val notesList: List<Notes>) :
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
        val Data=notesList[position]
        holder.binding.notesRVTitle.text=Data.title
        holder.binding.notesRVNotes.text=Data.notes
        holder.binding.notesRVDate.text=Data.date

    }
}