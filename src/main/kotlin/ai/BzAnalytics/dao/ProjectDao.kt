package ai.BzAnalytics.dao

import ai.BzAnalytics.dao.Employee.autoIncrement
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.Table

object Project : Table() {
    val projectId = integer("ProjectId").autoIncrement()
    val name =  varchar("ProjectName",50)
    //val allocations = varchar("Allocations",100).nullable()
    override val primaryKey = PrimaryKey(projectId)
}