package com.example.lab1.models

data class Post(
    val text: String,
    val imageURL: String?,
    val likes: Int,
    val comments: Int,
)