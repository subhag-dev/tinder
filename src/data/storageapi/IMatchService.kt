package data.storageapi

import data.model.User

interface IMatchService {

    fun like(likingUserName: String, likedUserName: String): Boolean

    fun ignore(ignoringUserName: String, ignoredUserName: String): Boolean

    fun showMatches(userName: String): List<User>

    fun showAllMatches(): Map<String, List<String>>

    fun getPotentialMatches(userName: String): List<String>

}