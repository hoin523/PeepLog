package me.uni98.application.repository

import me.uni98.application.model.Friend
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FriendRepository : JpaRepository<Friend, Long> {
    fun findByUserId(userId: Long): List<Friend>
}
