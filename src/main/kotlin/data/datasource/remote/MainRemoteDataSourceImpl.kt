package data.datasource.remote

import common.AppConstants.URL
import common.AppConstants.TOKEN
import common.Role
import common.getOrThrow
import domain.model.BranchResponse
import domain.model.ProjectResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter

class MainRemoteDataSourceImpl(
    private val httpClient: HttpClient,
) : MainRemoteDataSource {
    override suspend fun getProjects(
        isSimple: Boolean,
        includeArchived: Boolean,
        orderBy: String,
        sortAscending: Boolean,
        minAccessLevel: Role,
        perPage: Int,
    ): List<ProjectResponse> {
        val response = httpClient.get(URL) {
            headers.append("Authorization", "Bearer $TOKEN")
            parameter("simple", isSimple)
            parameter("archived", includeArchived)
            parameter("order_by", orderBy)
            parameter("sort", if (sortAscending) "asc" else "desc")
            parameter("min_access_level", minAccessLevel.id)
            parameter("per_page", perPage)
        }

        return response.getOrThrow<List<ProjectResponse>>()
    }

    override suspend fun getBranches(
        projectId: Int,
        perPage: Int,
    ): List<BranchResponse> {
        val response = httpClient.get(
            "$URL/$projectId/repository/branches"
        ) {
            headers.append("Authorization", "Bearer $TOKEN")
            parameter("per_page", perPage)
        }
        return response.getOrThrow<List<BranchResponse>>()
    }
}

