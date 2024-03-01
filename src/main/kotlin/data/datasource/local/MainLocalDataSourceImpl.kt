package data.datasource.local

import data.preference.PreferenceManager
import domain.model.UserData

class MainLocalDataSourceImpl(
    private val preferenceManager: PreferenceManager
) : MainLocalDataSource {
    override fun saveToken(token: String) {
        preferenceManager.saveToken(token)
    }

    override fun restoreToken(defaultValue: String): String {
        return preferenceManager.restoreToken(defaultValue)
    }

    override fun saveLocale(locale: String) {
        preferenceManager.saveLocale(locale)
    }

    override fun restoreLocale(default: String): String {
        return preferenceManager.restoreLocale(default)
    }

    override fun saveUserData(userData: UserData) {
        preferenceManager.saveUserData(userData)
    }

    override fun getUserData(): UserData {
        return preferenceManager.getUserData()
    }
}
