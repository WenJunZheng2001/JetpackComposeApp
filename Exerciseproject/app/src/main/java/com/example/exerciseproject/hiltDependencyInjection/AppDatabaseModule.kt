package com.example.exerciseproject.hiltDependencyInjection

import android.content.Context
import androidx.room.Room
import com.example.exerciseproject.database.AppDatabase
import com.example.exerciseproject.database.NoteInfoDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jakarta.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppDatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(
        @ApplicationContext context: Context
    ): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database"
        ).build()
    }

    @Provides
    fun provideNoteInfoDao(
        database: AppDatabase
    ): NoteInfoDao {
        return database.noteInfoDao()
    }
}