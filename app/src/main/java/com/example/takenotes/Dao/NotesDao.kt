package com.example.takenotes.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.takenotes.Model.Notes

@Dao
interface NotesDao {
    @Query("Select * from Notes")
    fun getNotes():LiveData<List<Notes>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotes(notes: Notes)

    @Query("Delete from Notes where Id=:id")
    fun deleteNotes(id:Int)

    @Update
    fun updateNotes(notes: Notes)


}