package me.uni98.application.dto

data class FriendDto(
    val id: Long? = null,
    val name: String,
    val phoneNumber: String? = null,
    val userId: Long,
    val height: String? = null,
    val weight: String? = null,
    val hobbies: String? = null,
    val memo: String? = null
)
