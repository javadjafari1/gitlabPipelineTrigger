package domain.repo

import domain.model.BranchResponse
import domain.model.ProjectResponse
import domain.model.TriggerResponse
import domain.model.TriggerTokenResponse

interface MainRepository {
    suspend fun getProjects(): List<ProjectResponse>
    suspend fun getBranches(projectId: Int): List<BranchResponse>

    suspend fun trigger(
        projectId: Int,
        branchName: String,
        variables: Map<String, String>
    ): TriggerResponse

    suspend fun getProjectTriggerTokens(
        projectId: Int
    ): List<TriggerTokenResponse>

    fun saveToken(token: String)
    fun restoreToken(defaultValue: String): String
    fun saveLocale(locale: String)
    fun restoreLocale(default: String): String
}
