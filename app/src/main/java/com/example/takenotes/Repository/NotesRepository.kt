package com.example.takenotes.Repository

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.lifecycle.LiveData
import com.example.takenotes.Dao.NotesDao
import com.example.takenotes.Model.Notes

class NotesRepository(val dao: NotesDao) {

    fun getAllNotes(): LiveData<List<Notes>> {
        return dao.getNotes()
    }

    fun insertNotes(notes: Notes) {
        dao.insertNotes(notes)
    }

    fun deleteNotes(id: Int) {
        dao.deleteNotes(id)
    }

    fun updateNotes(notes: Notes) {
        dao.updateNotes(notes)
    }
}