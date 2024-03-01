package data.preference

import domain.model.UserData
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

    override fun saveLocale(locale: String) {
        preferences.put(LOCALE_KEY, locale)
    }

    override fun restoreLocale(default: String): String {
        return preferences.get(LOCALE_KEY, default)
    }

    override fun saveUserData(userData: UserData) {
        preferences.put(TOKEN_KEY, userData.token)
        preferences.put(USERNAME_KEY, userData.username)
        preferences.putInt(ID_KEY, userData.id)
        preferences.put(NAME_KEY, userData.name)
        preferences.put(AVATAR_URL_KEY, userData.avatarUrl)
        preferences.put(STATE_KEY, userData.state)
        preferences.put(WEB_URL_KEY, userData.webUrl)
        preferences.put(BIO_KEY, userData.bio)
        preferences.put(JOB_TITLE_KEY, userData.jobTitle)
    }

    override fun getUserData(): UserData {
        return UserData(
            token = preferences.get(TOKEN_KEY, null),
            username = preferences.get(USERNAME_KEY, null),
            id = preferences.getInt(ID_KEY, 0),
            name = preferences.get(NAME_KEY, null),
            avatarUrl = preferences.get(AVATAR_URL_KEY, null),
            state = preferences.get(STATE_KEY, null),
            webUrl = preferences.get(WEB_URL_KEY, null),
            bio = preferences.get(BIO_KEY, null),
            jobTitle = preferences.get(JOB_TITLE_KEY, null),
        )
    }

    companion object {
        const val LOCALE_KEY = "locale"

        private const val TOKEN_KEY = "vmeoirs"
        private const val USERNAME_KEY = "spdoevmc"
        private const val ID_KEY = "weu3igjsdvb"
        private const val NAME_KEY = "iweurvmd"
        private const val AVATAR_URL_KEY = "xncvsiwe"
        private const val STATE_KEY = "swefojvi"
        private const val WEB_URL_KEY = "segrjoiegroids"
        private const val BIO_KEY = "sefjwmvi"
        private const val JOB_TITLE_KEY = "ieofbme9"
    }
}
