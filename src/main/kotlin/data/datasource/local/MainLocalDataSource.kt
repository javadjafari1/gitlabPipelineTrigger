package data.datasource.local

interface MainLocalDataSource {
    fun saveToken(token: String)
    fun restoreToken(defaultValue: String): String
}
