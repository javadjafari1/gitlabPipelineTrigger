package data.preference

import java.util.prefs.Preferences

class PreferenceManagerImpl(
    private val preferences: Preferences,
) : PreferenceManager {
    override fun saveToken(token: String) {
        preferences.put(TOKEN_KEY, token)
    }

    override fun restoreToken(defaultValue: String): String {
        return preferences.get(TOKEN_KEY, defaultValue)
    }

    companion object {
        const val TOKEN_KEY = "token"
    }
}
