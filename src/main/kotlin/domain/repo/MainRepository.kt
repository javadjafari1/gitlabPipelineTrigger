package domain.repo

interface MainRepository {
    suspend fun getProjectList()
    suspend fun getBranchList()
    suspend fun saveToken(token: String)
    suspend fun restoreToken(): String
}
