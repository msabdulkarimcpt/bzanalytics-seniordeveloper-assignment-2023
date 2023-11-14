package ai.BzAnalytics.dao

import ai.BzAnalytics.dao.Project
import ai.BzAnalytics.dao.Technology
import org.jetbrains.exposed.sql.Table

//import org.jetbrains.exposed.dao.id.IntIdTable


object Employee : Table() {
    val employeeId = integer("EmployeeId").autoIncrement()
    val firstName = varchar("FirstName", 50)
    val lastName = varchar("LastName", 50)
    //val project = integer("CurrentProject").references(Project.projectId)
    val primarySkill = integer("PrimarySkill").references(Technology.id)
    val secondarySkill = integer("SecondarySkill").references(Technology.id).nullable()
    //val experience = integer("Experience")
    val startDate = varchar("StartDate", 20)
    val endDate = varchar("EndDate", 20)

    override val primaryKey = PrimaryKey(employeeId)
}