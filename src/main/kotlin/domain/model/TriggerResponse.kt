package domain.model

import kotlinx.serialization.Serializable

@Serializable
data class TriggerResponse(
    val beforeSha: String,
    val createdAt: String,
    val detailedStatusResponse: DetailedStatusResponse?,
    val id: Int,
    val iid: Int,
    val projectId: Int,
    val ref: String,
    val sha: String,
    val source: String,
    val status: String,
    val tag: Boolean,
    val updatedAt: String,
    val userResponse: UserResponse?,
    val webUrl: String,
)
