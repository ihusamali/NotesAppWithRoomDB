package com.example.notesappwithroom.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notesTable")
data class Note (

    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title :String,
    val description: String,
    val timeStamp: String
)