package ai.BzAnalytics.entities
/**
 * A model for a project
 * @param id Project id
 * @param name Name of the project
 * @param allocations list of allocations for the project
 */
data class Project (
    val id: Int,
    val name: String,
    val allocations: List<ProjectAllocation>
) {
}