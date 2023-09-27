package ai.BzAnalytics.entities
/**
 * A model for a new project requirement
 * @param skill is the skill required
 * @param count is the number of required employees with the particular skill
 */
data class ProjectRequirement (
    val skill: Technology,
    val count: Int
) {
}