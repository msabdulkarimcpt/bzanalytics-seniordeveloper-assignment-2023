package ai.BzAnalytics.entities

import kotlinx.serialization.Serializable

/**
 * A model for a project
 * @param id Project id
 * @param name Name of the project
 * @param allocations list of allocations for the project
 */
@Serializable
data class Project (
    val id: Int,
    val name: String,
    //val allocations: List<ProjectAllocation>
) {
}

@Serializable
data class ProjectCurrent (
    val id: Int,
    val name: String,
    val startDate: String,
    val employees: List<EmployeeTemp>
) {
}