package me.uni98.application.service

import me.uni98.application.dto.FriendDto
import me.uni98.application.model.Friend
import me.uni98.application.model.FriendDetail
import me.uni98.application.repository.FriendDetailRepository
import me.uni98.application.repository.FriendRepository
import me.uni98.application.repository.UserRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class FriendService(
    private val friendRepository: FriendRepository,
    private val friendDetailRepository: FriendDetailRepository,
    private val userRepository: UserRepository
) {

    @Transactional
    fun createFriend(friendDto: FriendDto): FriendDto {
        val user = userRepository.findByIdOrNull(friendDto.userId)
            ?: throw IllegalArgumentException("User not found with ID: ${friendDto.userId}")

        val friend = Friend(
            name = friendDto.name,
            phoneNumber = friendDto.phoneNumber,
            user = user
        )
        val savedFriend = friendRepository.save(friend)

        val friendDetail = FriendDetail(
            height = friendDto.height,
            weight = friendDto.weight,
            hobbies = friendDto.hobbies,
            memo = friendDto.memo,
            friend = savedFriend
        )
        friendDetailRepository.save(friendDetail)

        return convertToDto(savedFriend, friendDetail)
    }

    @Transactional(readOnly = true)
    fun getFriendById(id: Long): FriendDto? {
        val friend = friendRepository.findByIdOrNull(id)
        return friend?.let { f ->
            val detail = friendDetailRepository.findByFriendId(f.id)
            convertToDto(f, detail)
        }
    }

    @Transactional(readOnly = true)
    fun getAllFriendsByUserId(userId: Long): List<FriendDto> {
        val friends = friendRepository.findByUserId(userId)
        return friends.map { f ->
            val detail = friendDetailRepository.findByFriendId(f.id)
            convertToDto(f, detail)
        }
    }

    @Transactional
    fun updateFriend(id: Long, friendDto: FriendDto): FriendDto {
        val existingFriend = friendRepository.findByIdOrNull(id)
            ?: throw IllegalArgumentException("Friend not found with ID: $id")

        existingFriend.name = friendDto.name
        existingFriend.phoneNumber = friendDto.phoneNumber
        val updatedFriend = friendRepository.save(existingFriend)

        var existingDetail = friendDetailRepository.findByFriendId(updatedFriend.id)
        if (existingDetail == null) {
            existingDetail = FriendDetail(friend = updatedFriend)
        }
        existingDetail.height = friendDto.height
        existingDetail.weight = friendDto.weight
        existingDetail.hobbies = friendDto.hobbies
        existingDetail.memo = friendDto.memo
        val updatedDetail = friendDetailRepository.save(existingDetail)

        return convertToDto(updatedFriend, updatedDetail)
    }

    @Transactional
    fun deleteFriend(id: Long) {
        val friend = friendRepository.findByIdOrNull(id)
            ?: throw IllegalArgumentException("Friend not found with ID: $id")

        friendDetailRepository.findByFriendId(friend.id)?.let { detail ->
            friendDetailRepository.delete(detail)
        }
        friendRepository.delete(friend)
    }

    private fun convertToDto(friend: Friend, friendDetail: FriendDetail?): FriendDto {
        return FriendDto(
            id = friend.id,
            name = friend.name,
            phoneNumber = friend.phoneNumber,
            userId = friend.user.id,
            height = friendDetail?.height,
            weight = friendDetail?.weight,
            hobbies = friendDetail?.hobbies,
            memo = friendDetail?.memo
        )
    }
}
