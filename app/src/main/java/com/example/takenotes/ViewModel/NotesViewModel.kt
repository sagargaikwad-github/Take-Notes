package com.example.takenotes.ViewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.takenotes.Database.NotesDatabase
import com.example.takenotes.Model.Notes
import com.example.takenotes.Repository.NotesRepository

class NotesViewModel(application: Application) : AndroidViewModel(application) {
    val respository: NotesRepository
    val dao = NotesDatabase.getDataBaseInstance(application).mNotesDao()

    init {
        respository = NotesRepository(dao)
    }

    fun addNotes(notes: Notes) {
        respository.insertNotes(notes)
    }

    fun getNotes(): LiveData<List<Notes>> = respository.getAllNotes()

    fun deleteNotes(id: Int) {
        respository.deleteNotes(id)
    }

    fun updateNotes(notes: Notes) {
        respository.updateNotes(notes)
    }
}