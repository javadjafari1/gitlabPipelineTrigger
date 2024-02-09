package domain.repo

interface MainRepository {
    suspend fun getProjectList()
    suspend fun getBranchList()
    fun saveToken(token: String)
    fun restoreToken(defaultValue: String): String
    fun saveLocale(locale: String)
    fun restoreLocale(default: String): String
}
