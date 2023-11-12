package ai.BzAnalytics.entities

import kotlinx.serialization.Serializable

@Serializable
data class Technology (
    val id: Int,
    val name: String
)