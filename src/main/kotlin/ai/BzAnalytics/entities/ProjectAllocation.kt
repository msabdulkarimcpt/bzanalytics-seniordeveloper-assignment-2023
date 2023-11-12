package ai.BzAnalytics.entities

import kotlinx.serialization.Serializable

/**
 * A model for a project allocation
 * @param employee is an employee allocated for the project
 * @param startMonth is the month the employee started working on the project
 * @param endMonth is the month the employee last worked on the project. NULL if still allocated.
 * @param startYear is the Year the employee started working on the project
 * @param endYear is the Year the employee last worked on the project. NULL if still allocated.
 */
@Serializable
data class ProjectAllocation (
    val employee: Employee,
    val startMonth: Int,
    val endMonth: Int,
    val startYear: Int?,
    val endYear: Int?
) {
}