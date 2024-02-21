package domain.model

import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    val avatarUrl: String,
    val id: Int,
    val name: String,
    val state: String,
    val username: String,
    val webUrl: String
)
