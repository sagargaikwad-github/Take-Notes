package com.example.takenotes.Model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Notes")
class Notes(
    @PrimaryKey(autoGenerate = true)
    var Id: Int? = null,
    var title: String,
    var notes: String,
    var date: String
)