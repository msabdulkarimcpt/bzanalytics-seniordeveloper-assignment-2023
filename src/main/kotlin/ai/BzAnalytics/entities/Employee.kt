package ai.BzAnalytics.entities

import kotlinx.serialization.Serializable

/**
 * A model for an employee
 * @param id Employee id (Unique)
 * @param firstName First Name of the employee
 * @param lastName Last Name of the employee
 * @param primarySkill Primary skill of the employee
 * @param secondarySkill Secondary skill of the employee
 * @param project The project the employee is currently working in, could be NULL if unallocated.
 * @param experience Work experience of the employee within the company in months.
 */

@Serializable
data class Employee(
    val id: Int,
    val firstName: String,
    val lastName: String,
    val primarySkill: Technology,
    val secondarySkill: Technology?,
    val project: Project?,
    val experience: Int
) {
}