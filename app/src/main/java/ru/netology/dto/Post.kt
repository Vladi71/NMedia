package ru.netology.dto

data class Post(
   val id: Long,
   val author: String,
   val content: String,
   val published: String,
   var likedByMe: Boolean = false,
   var numberOfLike: Int,
   var numberOfView: Int,
   var numberOfShare: Int
)