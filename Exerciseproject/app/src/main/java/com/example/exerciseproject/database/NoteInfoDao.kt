package com.example.exerciseproject.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteInfoDao {
    @Query("SELECT * FROM noteInfo")
    fun getAll(): Flow<List<NoteInfoEntity>>

//    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
//    fun loadAllByIds(userIds: IntArray): List<NoteInfo>

//    @Query("SELECT * FROM note WHERE first_name LIKE :first AND " +
//            "last_name LIKE :last LIMIT 1")
//    fun findByName(title: String, description: String): NoteInfo

    @Insert
    suspend fun insert(noteInfo: NoteInfoEntity)

    @Delete
    suspend fun delete(noteInfo: NoteInfoEntity)
}