package ai.BzAnalytics.dao

import org.jetbrains.exposed.sql.Table

object ProjectAllocation : Table() {
    val employee = integer("EmployeeId").references(Employee.employeeId)
    val project = integer("ProjectId").references(Project.projectId)
    val startMonth = integer("startMonth")
    val startYear = integer("startYear")
    val endMonth = integer("endMonth").nullable()
    val endYear = integer("endYear").nullable()
}