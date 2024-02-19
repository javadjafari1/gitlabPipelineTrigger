package domain.model

import kotlinx.serialization.Serializable

@Serializable
data class ProjectResponse(
    val avatarUrl: String?,
    val createdAt: String,
    val defaultBranch: String,
    val description: String?,
    val forksCount: Int,
    val httpUrlToRepo: String,
    val id: Int,
    val lastActivityAt: String,
    val name: String,
    val nameWithNamespace: String,
    val path: String,
    val starCount: Int,
    val webUrl: String
)
