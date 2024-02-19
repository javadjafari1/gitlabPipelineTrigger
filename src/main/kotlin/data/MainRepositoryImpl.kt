package data

import common.Role
import data.datasource.local.MainLocalDataSource
import data.datasource.remote.MainRemoteDataSource
import domain.model.BranchResponse
import domain.model.ProjectResponse
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
}
