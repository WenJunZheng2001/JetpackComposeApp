package com.example.exerciseproject.database

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [NoteInfoEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteInfoDao(): NoteInfoDao
}