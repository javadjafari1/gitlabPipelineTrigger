package domain.model

import kotlinx.serialization.Serializable

@Serializable
data class DetailedStatusResponse(
    val detailsPath: String,
    val favicon: String,
    val group: String,
    val hasDetails: Boolean,
    val icon: String,
    val label: String,
    val text: String,
    val tooltip: String,
)
