package utils

import data.model.User

class UserComparatorUtils (
        private val user: User,
) {

    val comparator =  Comparator<User> { user1, user2 ->
        if (isGenderOpposite(user, user1) && !isGenderOpposite(user, user2)) {
            -1
        }
        else if (!isGenderOpposite(user, user1) && isGenderOpposite(user, user2)) {
            1
        }
        else if (getNearerOfTheTwoUsers(user1, user2, user) == user1) {
            -1
        }
        else if (getNearerOfTheTwoUsers(user1, user2, user) == user2) {
            1
        }
        else if (kotlin.math.abs(user.age - user1.age) < kotlin.math.abs(user2.age - user.age)) {
            -1
        }
        else 1
    }

    companion object {

        fun isGenderOpposite(user1: User, user2: User): Boolean {
            return user1.gender != user2.gender
        }

        fun getNearerOfTheTwoUsers(user1: User, user2: User, targetUser: User): User {
            val d1 = (user1.location.x - targetUser.location.x) * (user1.location.x - targetUser.location.x)
                    + (user1.location.y - targetUser.location.y) * (user1.location.y - targetUser.location.y)

            val d2 = (user2.location.x - targetUser.location.x) * (user2.location.x - targetUser.location.x)
                    + (user2.location.y - targetUser.location.y) * (user2.location.y - targetUser.location.y)

            return if (d1 < d2) {
                user1
            } else {
                user2
            }
        }

    }

}