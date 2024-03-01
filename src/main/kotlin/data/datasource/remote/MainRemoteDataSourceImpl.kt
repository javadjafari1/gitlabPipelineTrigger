package data.datasource.remote

import common.Role
import data.api.GitlabApi
import domain.model.BranchResponse
import domain.model.ProjectResponse
import domain.model.TriggerResponse
import domain.model.TriggerTokenResponse
import domain.model.UserResponse

class MainRemoteDataSourceImpl(
    private val gitlabApi: GitlabApi
) : MainRemoteDataSource {
    override suspend fun getProjects(
        isSimple: Boolean,
        includeArchived: Boolean,
        orderBy: String,
        sortAscending: Boolean,
        minAccessLevel: Role,
        perPage: Int,
    ): List<ProjectResponse> {
        return gitlabApi.getProjects(
            isSimple = isSimple,
            includeArchived = includeArchived,
            orderBy = orderBy,
            sortAscending = sortAscending,
            minAccessLevel = minAccessLevel,
            perPage = perPage,
        )
    }

    override suspend fun getBranches(
        projectId: Int,
        perPage: Int,
    ): List<BranchResponse> {
        return gitlabApi.getBranches(
            projectId = projectId,
            perPage = perPage,
        )
    }

    override suspend fun trigger(
        projectId: Int,
        branchName: String,
        variables: Map<String, String>
    ): TriggerResponse {
        return gitlabApi.trigger(
            projectId = projectId,
            branchName = branchName,
            variables = variables
        )
    }

    override suspend fun getProjectTriggerTokens(
        projectId: Int
    ): List<TriggerTokenResponse> {
        return gitlabApi.getProjectTriggerTokens(
            projectId = projectId
        )
    }

    override suspend fun getUserDetail(
        address: String,
        token: String
    ): UserResponse {
        return gitlabApi.getUserDetail(
            address = address,
            token = token
        )
    }
}
