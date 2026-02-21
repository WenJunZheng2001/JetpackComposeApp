package com.example.exerciseproject.services

import com.example.exerciseproject.database.NoteInfoDao
import com.example.exerciseproject.database.NoteInfoEntity
import com.example.exerciseproject.models.NoteInfo


import javax.inject.Inject

class NoteInfoRepository @Inject constructor(){
//    suspend fun addNewNote(title: String, description: String){
//        noteInfoDao.insert(NoteInfoEntity(title = title, description = description))
//    }
//
//    fun getAllNotes(): Flow<List<NoteInfo>> {
//        return noteInfoDao.getAll()
//            .map { list -> list.map { it.toDomain() } }   // map to domain model
//    }

    fun test(){
        print("hi")
    }

//    fun NoteInfoEntity.toDomain(): NoteInfo = NoteInfo(
//        id = uid,
//        title = title ?: "",
//        description = description ?: ""
//    )
//
//    fun NoteInfo.toEntity(): NoteInfoEntity = NoteInfoEntity(
//        uid = id,
//        title = title,
//        description = description
//    )

}