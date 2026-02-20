package com.example.exerciseproject.viewModelStore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.exerciseproject.models.NoteInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class BlockNoteViewModel: ViewModel() {
    private val _newNoteState = MutableStateFlow(NoteInfo(-1, "", ""))
    val newNoteState: StateFlow<NoteInfo> = _newNoteState.asStateFlow()
    private val _listOfNotes = MutableStateFlow(listOf<NoteInfo>())
    val listOfNotesState: StateFlow<List<NoteInfo>> = _listOfNotes.asStateFlow()

    init {
        viewModelScope.launch {

        }
    }

    fun updateNewNote(title: String? = null, description: String? = null){
        _newNoteState.update {
            it.copy(
                title = title ?: it.title,
                description = description ?: it.description)
        }
    }
    fun getModelById(id:Int): NoteInfo?{
        return listOfNotesState.value.find { it.id == id  }
    }
}