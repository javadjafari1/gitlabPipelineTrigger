package data.preference

interface PreferenceManager {
    fun saveToken(token: String)
    fun restoreToken(defaultValue: String): String
    fun saveLocale(locale: String)
    fun restoreLocale(default: String): String
}
