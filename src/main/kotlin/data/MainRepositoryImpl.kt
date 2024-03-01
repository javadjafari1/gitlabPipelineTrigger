package data

import common.Role
import data.datasource.local.MainLocalDataSource
import data.datasource.remote.MainRemoteDataSource
import domain.model.BranchResponse
import domain.model.ProjectResponse
import domain.model.TriggerResponse
import domain.model.TriggerTokenResponse
import domain.model.UserData
import domain.repo.MainRepository

class MainRepositoryImpl(
    private val mainRemoteDataSource: MainRemoteDataSource,
    private val mainLocalDataSource: MainLocalDataSource,
) : MainRepository {
    override suspend fun getProjects(): List<ProjectResponse> {
        return mainRemoteDataSource.getProjects(
            isSimple = true,
            includeArchived = false,
            orderBy = "id",
            sortAscending = true,
            minAccessLevel = Role.Guest,
            perPage = 100
        )
    }

    override suspend fun getBranches(projectId: Int): List<BranchResponse> {
        return mainRemoteDataSource.getBranches(
            projectId = projectId,
            perPage = 100
        )
    }

    override suspend fun trigger(
        projectId: Int,
        branchName: String,
        variables: Map<String, String>
    ): TriggerResponse {
        return mainRemoteDataSource.trigger(
            projectId = projectId,
            branchName = branchName,
            variables = variables
        )
    }

    override suspend fun getProjectTriggerTokens(projectId: Int): List<TriggerTokenResponse> {
        return mainRemoteDataSource.getProjectTriggerTokens(projectId)
    }

    override fun saveToken(token: String) {
        mainLocalDataSource.saveToken(token)
    }

    override fun restoreToken(defaultValue: String): String {
        return mainLocalDataSource.restoreToken(defaultValue = defaultValue)
    }

    override fun saveLocale(locale: String) {
        mainLocalDataSource.saveLocale(locale)
    }

    override fun restoreLocale(default: String): String {
        return mainLocalDataSource.restoreLocale(default)
    }

    override suspend fun getUserDetail(
        address: String,
        token: String
    ) {
        val response = mainRemoteDataSource.getUserDetail(
            address = address,
            token = token
        )
        mainLocalDataSource.saveUserData(
            UserData(
                token = token,
                username = response.username,
                id = response.id,
                name = response.name,
                avatarUrl = response.avatarUrl,
                state = response.state,
                webUrl = response.webUrl,
                bio = response.bio,
                jobTitle = response.jobTitle
            )
        )
    }
}
