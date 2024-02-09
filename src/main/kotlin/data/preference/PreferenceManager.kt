package data.preference

interface PreferenceManager {
    fun saveToken(token: String)
    fun restoreToken(defaultValue: String): String
}