package data.model

import java.util.Date

data class Match(
    val id: Int,
    val user1: User,
    val user2: User,
    val createdAt: Date
)
