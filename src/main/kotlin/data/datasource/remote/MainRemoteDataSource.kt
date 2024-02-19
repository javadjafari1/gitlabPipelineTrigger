package data.datasource.remote

import common.Role
import domain.model.ProjectResponse

interface MainRemoteDataSource {
    suspend fun getProjects(
        isSimple: Boolean = true,
        includeArchived: Boolean = false,
        orderBy: String,
        sortAscending: Boolean = true,
        minAccessLevel: Role,
        perPage: Int,
    ): List<ProjectResponse>
}

