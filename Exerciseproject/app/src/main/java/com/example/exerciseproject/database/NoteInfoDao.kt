package com.example.exerciseproject.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.exerciseproject.models.NoteInfo

@Dao
interface NoteInfoDao {
    @Query("SELECT * FROM noteInfo")
    fun getAll(): List<NoteInfo>

//    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
//    fun loadAllByIds(userIds: IntArray): List<NoteInfo>

//    @Query("SELECT * FROM note WHERE first_name LIKE :first AND " +
//            "last_name LIKE :last LIMIT 1")
//    fun findByName(title: String, description: String): NoteInfo

    @Insert
    fun insert(noteInfo: NoteInfo)

    @Delete
    fun delete(id: Int)
}