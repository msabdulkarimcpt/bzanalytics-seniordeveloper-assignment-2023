package ai.BzAnalytics.dao

import org.jetbrains.exposed.dao.id.IntIdTable

object Project : IntIdTable() {
    val name =  varchar("Name",50)
    //val allocations = varchar("Allocations",100).nullable()
}