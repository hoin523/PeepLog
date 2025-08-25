package me.uni98.application.model

import javax.persistence.*

@Entity
data class FriendDetail(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    var height: String? = null,
    var weight: String? = null,
    var hobbies: String? = null,
    @Column(length = 1000)
    var memo: String? = null,

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "friend_id")
    var friend: Friend
)
