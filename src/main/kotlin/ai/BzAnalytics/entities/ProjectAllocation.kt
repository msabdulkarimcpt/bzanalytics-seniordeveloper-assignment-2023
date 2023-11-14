package ai.BzAnalytics.entities

import kotlinx.serialization.Serializable

/**
 * A model for a project allocation
 * @param employee is an employee allocated for the project
 * @param startMonth is the month the employee started working on the project
 * @param startYear is the Year the employee started working on the project
 * @param endMonth is the month the employee last worked on the project. NULL if still allocated.
 * @param endYear is the Year the employee last worked on the project. NULL if still allocated.
 */
@Serializable
data class ProjectAllocation (
    val employee: Employee,
    val project: Project,
    val startMonth: Int,
    val startYear: Int?,
    val endMonth: Int?,
    val endYear: Int?
) {
}