package ai.BzAnalytics.dao

import org.jetbrains.exposed.dao.id.IntIdTable

object NewProject : IntIdTable() {
    val name = varchar("name",20)
    val requirements = reference("ProjectRequirement",ProjectRequirement)
}