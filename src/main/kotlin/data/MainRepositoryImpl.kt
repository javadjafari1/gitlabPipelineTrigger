package data

import data.datasource.local.MainLocalDataSource
import data.datasource.remote.MainRemoteDataSource
import domain.repo.MainRepository

class MainRepositoryImpl(
    private val mainRemoteDataSource: MainRemoteDataSource,
    private val mainLocalDataSource: MainLocalDataSource,
) : MainRepository {
    override suspend fun getProjectList() {
        TODO("Not yet implemented")
    }

    override suspend fun getBranchList() {
        TODO("Not yet implemented")
    }

    override suspend fun saveToken(token: String) {
        TODO("Not yet implemented")
    }

    override suspend fun restoreToken(): String {
        TODO("Not yet implemented")
    }
}