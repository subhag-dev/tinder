package data.model

import common.constants.ActionType
import common.constants.Gender

class User (
        private val id: Int = 0,
        val name: String? = null,
        val gender: Gender? = null,
        val age: Int = 0,
        val location: Location,
        private val mobileNo: String? = null
) {

    private var isActive: Boolean = false
    private var matches: List<Match> = listOf()
    private var userActionMap: Map<User, ActionType> = mapOf()
    private var usersWhoLikedYou: List<User> = listOf()

    fun setIsActive(active: Boolean) {
        this.isActive = active
    }

    fun setMatches(matches: List<Match>) {
        this.matches = matches
    }

    fun setUserActionMap(userActions: Map<User, ActionType>) {
        this.userActionMap = userActions
    }

    fun setUsersWhoLikedYou(usersWhoLikedYou: List<User>) {
        this.usersWhoLikedYou = usersWhoLikedYou
    }

    fun getIsActive(): Boolean {
        return isActive
    }

    fun getMatches(): List<Match> {
        return matches
    }

    fun getUserActionMap(): Map<User, ActionType> {
        return userActionMap
    }

    fun getUsersWhoLikedYou(): List<User> {
        return usersWhoLikedYou
    }

}
