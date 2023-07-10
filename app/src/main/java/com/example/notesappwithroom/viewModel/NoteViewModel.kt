package com.example.notesappwithroom.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.notesappwithroom.db.Note
import com.example.notesappwithroom.db.NoteDatabase
import com.example.notesappwithroom.repository.NoteRepository
import kotlinx.coroutines.launch

class NoteViewModel (application: Application) : AndroidViewModel(application) {

    lateinit var allNotes : LiveData<List<Note>>
    lateinit var repository : NoteRepository

    init {
        val dao = NoteDatabase.getDatabase(application).getNoteDao()
        val repository = NoteRepository(dao)
        allNotes = repository.allNotes
    }

    fun deleteNote (note: Note) = viewModelScope.launch {
        repository.deleteRep(note)
    }

    fun insertNote (note: Note) = viewModelScope.launch {
        repository.insertRep(note)
    }

    fun updateNote (note: Note) = viewModelScope.launch {
        repository.updateRep(note)
    }
}