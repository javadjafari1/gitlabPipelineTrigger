package domain.model

import kotlinx.serialization.Serializable

@Serializable
data class CommitResponse(
    val authorEmail: String,
    val authorName: String,
    val authoredDate: String,
    val committedDate: String,
    val committerEmail: String,
    val committerName: String,
    val createdAt: String,
    val id: String,
    val message: String,
    val shortId: String,
    val title: String,
    val webUrl: String,
)
