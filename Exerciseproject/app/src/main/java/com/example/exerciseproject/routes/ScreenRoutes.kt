package com.example.exerciseproject.routes

import com.example.exerciseproject.models.NoteInfo
import kotlinx.serialization.Serializable


@Serializable
object HomeScreenRoute

@Serializable
data class DetailScreenRoute(val title: String? = null)
