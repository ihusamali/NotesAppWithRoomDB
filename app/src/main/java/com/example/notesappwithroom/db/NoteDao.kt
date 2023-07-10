package com.example.notesappwithroom.db

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.IGNORE
import androidx.room.Query
import androidx.room.Update

interface NoteDao {
    @Insert(onConflict = IGNORE)
    suspend fun insert(note: Note)

    @Delete
    suspend fun delete(note: Note)

    @Query("SELECT * FROM notesTable order by id ASC")
    fun getAllNotes(): LiveData<List<Note>>

    @Update
    suspend fun update(note: Note)
}