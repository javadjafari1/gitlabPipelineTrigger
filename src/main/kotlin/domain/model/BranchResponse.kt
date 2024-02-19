package domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BranchResponse(
    val canPush: Boolean,
    val commitResponse: CommitResponse,
    val default: Boolean,
    val merged: Boolean,
    val name: String,
    @SerialName("protected")
    val isProtected: Boolean,
    val webUrl: String,
)
