package domain.model

import kotlinx.serialization.Serializable

@Serializable
data class UserResponse(
    val id: Int,
    val name: String,
    val username: String,
    val avatarUrl: String,
    val state: String,
    val webUrl: String,
    val createdAt: String,
    val bio: String,
    val publicEmail: String,
    val email: String,
    val jobTitle: String,
)
