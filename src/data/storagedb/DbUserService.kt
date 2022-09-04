package data.storagedb

import common.constants.Gender
import data.storageapi.IUserService

class DbUserService(val appDb: AppDatabase): IUserService {

    override fun createAccount(userName: String, xCoordinate: Int, yCoordinate: Int, age: Int, gender: Gender): Boolean {
        return appDb.createAccount()
    }

    override fun deleteAccount(userName: String): Boolean {
        TODO("Not yet implemented")
    }

}