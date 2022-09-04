package data.storagedb

import data.model.User
import utils.UserComparatorUtils

class AppDatabase {

    private var users: MutableMap<String, User> = mutableMapOf()
    private var likes: MutableMap<String, MutableSet<String> > = mutableMapOf()
    private val ignores: MutableMap<String, MutableSet<String> > = mutableMapOf()
    private var matches: MutableMap<String, MutableSet<String> > = mutableMapOf()

    fun createAccount(user: User) {
        users[user.name] = user
    }

    fun performLikeOperation(userA: String, userB: String): Boolean {
        if (likes.containsKey(userA)) {
            likes[userA]!!.add(userB)
        } else {
            likes[userA] = mutableSetOf(userB)
        }
        return true
    }

    fun performIgnoreOperation(userA: String, userB: String): Boolean {
        if (ignores.containsKey(userA)) {
            ignores[userA]!!.add(userB)
        } else {
            ignores[userA] = mutableSetOf(userB)
        }
        return true
    }

    fun getMatchesForUser(user: String): List<User> {
        val matchesForUser = matches[user] ?: return listOf()
        val matchList = mutableListOf<User>()
        matchesForUser.forEach { userName ->
            if (users.containsKey(userName)) {
                matchList.add(users[userName]!!)
            }
        }
        return matchList
    }

    fun showAllMatches(): MutableMap<String, List<String>> {
        val result = mutableMapOf<String, List<String>>()
        matches.forEach{
            result[it.key] = it.value.toList()
        }
        return result
    }

    fun getPotentialMatches(userName: String): List<String> {
        val user = users[userName]!!
        return users.values.toList().sortedWith ( UserComparatorUtils(user).comparator ).map {
            it.name!!
        }
    }

}