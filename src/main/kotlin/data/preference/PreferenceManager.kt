package data.preference

import domain.model.UserData

interface PreferenceManager {
    fun saveToken(token: String)
    fun restoreToken(defaultValue: String): String
    fun saveLocale(locale: String)
    fun restoreLocale(default: String): String
    fun saveUserData(userData: UserData)
    fun getUserData(): UserData
}
