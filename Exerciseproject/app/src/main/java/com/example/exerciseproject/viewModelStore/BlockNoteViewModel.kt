package com.example.exerciseproject.viewModelStore

import androidx.lifecycle.ViewModel
import com.example.exerciseproject.models.NoteInfo
import com.example.exerciseproject.services.NoteInfoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject


class BlockNoteViewModel : ViewModel() {
    private val _newNoteState = MutableStateFlow(NoteInfo(-1, "", ""))
    val newNoteState: StateFlow<NoteInfo> = _newNoteState.asStateFlow()
   private val _listOfNotes = MutableStateFlow(listOf<NoteInfo>())
   val listOfNotesState: StateFlow<List<NoteInfo>> = _listOfNotes.asStateFlow()
//    val notes: StateFlow<List<NoteInfo>> = repository.getAllNotes()
//    .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
//
//
//    init{
//        val scope = viewModelScope.launch {
//            repository.addNewNote("hi", "pizza")
//        }
//
//    }

    fun updateNewNote(title: String? = null, description: String? = null){
        _newNoteState.update {
            it.copy(
                title = title ?: it.title,
                description = description ?: it.description)
        }
    }
    fun getModelById(id:Int): NoteInfo?{
        return _listOfNotes.value.find { it.id == id  }
    }
}