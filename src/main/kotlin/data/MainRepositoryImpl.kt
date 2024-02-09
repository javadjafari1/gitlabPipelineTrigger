package data

import data.datasource.local.MainLocalDataSource
import data.datasource.remote.MainRemoteDataSource
import domain.repo.MainRepository

class MainRepositoryImpl(
    private val mainRemoteDataSource: MainRemoteDataSource,
    private val mainLocalDataSource: MainLocalDataSource,
) : MainRepository {
    override suspend fun getProjectList() {
        mainRemoteDataSource
        TODO("Not yet implemented")
    }

    override suspend fun getBranchList() {
        TODO("Not yet implemented")
    }

    override fun saveToken(token: String) {
        mainLocalDataSource.saveToken(token)
    }

    override fun restoreToken(defaultValue: String): String {
        return mainLocalDataSource.restoreToken(defaultValue = defaultValue)
    }
}
