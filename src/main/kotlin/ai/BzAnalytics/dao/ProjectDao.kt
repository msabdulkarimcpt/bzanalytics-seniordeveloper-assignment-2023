package ai.BzAnalytics.dao

import org.jetbrains.exposed.sql.Table

object Project : Table() {
    val projectId = integer("ProjectId").autoIncrement()
    val name =  varchar("ProjectName",50)
    override val primaryKey = PrimaryKey(projectId)
}