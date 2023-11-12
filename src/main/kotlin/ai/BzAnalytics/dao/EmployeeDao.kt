package ai.BzAnalytics.dao

import ai.BzAnalytics.dao.Project
import ai.BzAnalytics.dao.Technology

import org.jetbrains.exposed.dao.id.IntIdTable

object Employee : IntIdTable() {
    val firstName = varchar("FirstName", 50)
    val lastName = varchar("LastName", 50)
    val project = integer("CurrentProject").references(Project.id)
    val primarySkill = integer("PrimarySkill").references(Technology.id)
    val secondarySkill = integer("SecondarySkill").references(Technology.id).nullable()
    //val experience = integer("Experience")
    val startDate = varchar("StartDate", 20)
    val endDate = varchar("EndDate", 20)
}