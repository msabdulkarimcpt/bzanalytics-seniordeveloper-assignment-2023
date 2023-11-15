package ai.BzAnalytics.dao

import org.jetbrains.exposed.dao.id.IntIdTable

object ProjectRequirement : IntIdTable() {
    val skill = integer("Skill").references(Technology.id)
    val count =  integer("Count")
}