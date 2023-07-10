package com.example.notesappwithroom.repository

import androidx.lifecycle.LiveData
import com.example.notesappwithroom.db.Note
import com.example.notesappwithroom.db.NoteDao

class NoteRepository(private val dao: NoteDao) {

    val allNotes: LiveData<List<Note>> = dao.getAllNotes()

    suspend fun insertRep(note: Note) {
        dao.insert(note)
    }

    suspend fun updateRep(note: Note) {
        dao.update(note)
    }

    suspend fun deleteRep(note: Note) {
        dao.delete(note)
    }

}