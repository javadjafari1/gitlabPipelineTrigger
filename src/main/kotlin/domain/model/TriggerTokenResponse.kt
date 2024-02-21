package domain.model

import kotlinx.serialization.Serializable

@Serializable
data class TriggerTokenResponse(
    val id: Int,
    val token: String,
    val updatedAt: String,
    val createdAt: String,
    val description: String,
)
