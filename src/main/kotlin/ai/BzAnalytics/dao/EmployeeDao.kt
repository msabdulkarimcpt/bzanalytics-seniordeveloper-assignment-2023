package ai.BzAnalytics.dao


import org.jetbrains.exposed.sql.Table


object Employee : Table() {
    val employeeId = integer("EmployeeId").autoIncrement()
    val firstName = varchar("FirstName", 50)
    val lastName = varchar("LastName", 50)
    val primarySkill = integer("PrimarySkill").references(Technology.id)
    val secondarySkill = integer("SecondarySkill").references(Technology.id).nullable()
    val startDate = varchar("StartDate", 20)
    val endDate = varchar("EndDate", 20)
    override val primaryKey = PrimaryKey(employeeId)
}