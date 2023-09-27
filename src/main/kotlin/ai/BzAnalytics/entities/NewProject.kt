package ai.BzAnalytics.entities
/**
 * A model for a new project that needs allocations
 * @param name Name of the project
 * @param requirements list of requirements for the project
 */
data class NewProject (
    val name: String,
    val requirements: List<ProjectRequirement>
) {
}