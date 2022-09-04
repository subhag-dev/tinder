package data.storagedb

import data.model.User
import data.storageapi.IMatchService

class DbMatchService(private val appDb: AppDatabase): IMatchService {

    override fun like(likingUserName: String, likedUserName: String): Boolean {
        return appDb.performLikeOperation(likingUserName, likedUserName)
    }

    override fun ignore(ignoringUserName: String, ignoredUserName: String): Boolean {
        return appDb.performIgnoreOperation(ignoringUserName, ignoredUserName)
    }

    override fun showMatches(userName: String): List<User> {
        return appDb.getMatchesForUser(userName)
    }

    override fun showAllMatches(): Map<String, List<String>> {
        return appDb.showAllMatches()
    }

    override fun getPotentialMatches(userName: String): List<String> {
        return appDb.getPotentialMatches(userName)
    }

}