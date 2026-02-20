package com.example.exerciseproject.routes

import kotlinx.serialization.Serializable


@Serializable
object HomeScreenRoute

@Serializable
data class DetailScreenRoute(val noteId: Int?, val appBarTitle:String)
