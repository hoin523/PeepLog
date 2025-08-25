package me.uni98.application.repository

import me.uni98.application.model.FriendDetail
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FriendDetailRepository : JpaRepository<FriendDetail, Long> {
    fun findByFriendId(friendId: Long): FriendDetail?
}
