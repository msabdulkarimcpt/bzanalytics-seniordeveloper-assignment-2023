package ai.BzAnalytics.dao

import ai.BzAnalytics.dao.Employee
import org.jetbrains.exposed.dao.id.IntIdTable

object ProjectAllocation : IntIdTable() {
    val employee = integer("EmployeeId").references(Employee.id)
    val project = integer("ProjectId").references(Project.id)
    val startMonth = integer("startMonth")
    val endMonth = integer("startMonth")
    val startYear = integer("startMonth")
    val endYear = integer("startMonth")
}