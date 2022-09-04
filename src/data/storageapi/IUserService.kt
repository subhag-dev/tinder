package data.storageapi

import common.constants.Gender

interface IUserService {

    fun createAccount(userName: String, xCoordinate: Int, yCoordinate: Int, age: Int, gender: Gender): Boolean

    fun deleteAccount(userName: String): Boolean

}