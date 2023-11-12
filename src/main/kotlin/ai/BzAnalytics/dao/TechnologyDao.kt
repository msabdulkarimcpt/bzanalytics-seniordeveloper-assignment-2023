package ai.BzAnalytics.dao

import org.jetbrains.exposed.dao.id.IntIdTable

object Technology : IntIdTable() {
    val name = varchar("Name", 20)
}