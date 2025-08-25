package me.uni98.application.controller

import me.uni98.application.dto.FriendDto
import me.uni98.application.service.FriendService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/friends")
class FriendController(
    private val friendService: FriendService
) {

    @PostMapping
    fun createFriend(@RequestBody friendDto: FriendDto): ResponseEntity<FriendDto> {
        val createdFriend = friendService.createFriend(friendDto)
        return ResponseEntity(createdFriend, HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun getFriendById(@PathVariable id: Long): ResponseEntity<FriendDto> {
        val friend = friendService.getFriendById(id)
        return if (friend != null) {
            ResponseEntity(friend, HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @GetMapping("/user/{userId}")
    fun getAllFriendsByUserId(@PathVariable userId: Long): ResponseEntity<List<FriendDto>> {
        val friends = friendService.getAllFriendsByUserId(userId)
        return ResponseEntity(friends, HttpStatus.OK)
    }

    @PutMapping("/{id}")
    fun updateFriend(@PathVariable id: Long, @RequestBody friendDto: FriendDto): ResponseEntity<FriendDto> {
        return try {
            val updatedFriend = friendService.updateFriend(id, friendDto)
            ResponseEntity(updatedFriend, HttpStatus.OK)
        } catch (e: IllegalArgumentException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @DeleteMapping("/{id}")
    fun deleteFriend(@PathVariable id: Long): ResponseEntity<Void> {
        return try {
            friendService.deleteFriend(id)
            ResponseEntity(HttpStatus.NO_CONTENT)
        } catch (e: IllegalArgumentException) {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }
}
