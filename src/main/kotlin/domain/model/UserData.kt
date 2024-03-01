package domain.model

data class UserData(
    val token: String,
    val username: String,
    val id: Int,
    val name: String,
    val avatarUrl: String,
    val state: String,
    val webUrl: String,
    val bio: String,
    val jobTitle: String,
)
