package com.example.exerciseproject.models

import kotlinx.serialization.Serializable

@Serializable
data class NoteInfo(var title: String, var description: String)
