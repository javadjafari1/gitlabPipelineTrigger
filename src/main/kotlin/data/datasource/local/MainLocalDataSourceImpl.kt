package data.datasource.local

import data.preference.PreferenceManager

class MainLocalDataSourceImpl(
    private val preferenceManager: PreferenceManager
) : MainLocalDataSource {
    override fun saveToken(token: String) {
        preferenceManager.saveToken(token)
    }

    override fun restoreToken(defaultValue: String): String {
        return preferenceManager.restoreToken(defaultValue)
    }
}