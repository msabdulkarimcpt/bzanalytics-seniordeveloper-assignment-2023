package ai.BzAnalytics.entities

import kotlinx.serialization.Serializable

/**
 * A model for a new project requirement
 * @param skill is the skill required
 * @param count is the number of required employees with the particular skill
 */
@Serializable
data class ProjectRequirement (
    val skill: Technology,
    val count: Int
) {
}