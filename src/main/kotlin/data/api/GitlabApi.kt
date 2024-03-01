package data.api

import common.AppConstants
import common.AppConstants.API_VERSION
import common.Role
import common.getOrThrow
import domain.model.BranchResponse
import domain.model.ProjectResponse
import domain.model.TriggerResponse
import domain.model.TriggerTokenResponse
import domain.model.UserResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.post

class GitlabApi(
    private val httpClient: HttpClient
) {
    suspend fun getProjects(
        isSimple: Boolean,
        includeArchived: Boolean,
        orderBy: String,
        sortAscending: Boolean,
        minAccessLevel: Role,
        perPage: Int,
    ): List<ProjectResponse> {
        val response = httpClient.get(AppConstants.URL) {
            headers.append("Authorization", "Bearer ${AppConstants.TOKEN}")
            parameter("simple", isSimple)
            parameter("archived", includeArchived)
            parameter("order_by", orderBy)
            parameter("sort", if (sortAscending) "asc" else "desc")
            parameter("min_access_level", minAccessLevel.id)
            parameter("per_page", perPage)
        }

        return response.getOrThrow()
    }

    suspend fun getBranches(
        projectId: Int,
        perPage: Int,
    ): List<BranchResponse> {
        val response = httpClient.get(
            "${AppConstants.URL}/$projectId/repository/branches"
        ) {
            headers.append("Authorization", "Bearer ${AppConstants.TOKEN}")
            parameter("per_page", perPage)
        }
        return response.getOrThrow()
    }

    suspend fun trigger(
        projectId: Int,
        branchName: String,
        variables: Map<String, String>
    ): TriggerResponse {
        val response = httpClient.post(
            "${AppConstants.URL}/$projectId/trigger/pipeline"
        ) {
            headers.append("PRIVATE-TOKEN", AppConstants.TOKEN)
            parameter("access-token", AppConstants.TOKEN)
            parameter("ref", branchName)
            variables.forEach { (key, value) ->
                parameter(key, value)
            }
        }
        return response.getOrThrow()
    }

    suspend fun getProjectTriggerTokens(
        projectId: Int
    ): List<TriggerTokenResponse> {
        val response = httpClient.get("${AppConstants.URL}/$projectId/triggers") {
            headers.append("PRIVATE-TOKEN", AppConstants.TOKEN)
        }

        return response.getOrThrow()
    }

    suspend fun getUserDetail(
        address: String,
        token: String
    ): UserResponse {
        val response = httpClient.get(
            urlString = "$address/${API_VERSION}/user"
        ) {
            headers.append("PRIVATE-TOKEN", token)
        }

        return response.getOrThrow()
    }
}
