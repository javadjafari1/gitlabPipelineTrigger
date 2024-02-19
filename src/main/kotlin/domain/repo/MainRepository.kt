package domain.repo

import domain.model.ProjectResponse

interface MainRepository {
    suspend fun getProjects(): List<ProjectResponse>
    suspend fun getBranchList()
    fun saveToken(token: String)
    fun restoreToken(defaultValue: String): String
    fun saveLocale(locale: String)
    fun restoreLocale(default: String): String
}
