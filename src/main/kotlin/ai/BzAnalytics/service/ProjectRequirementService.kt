package ai.BzAnalytics.service

import ai.BzAnalytics.dao.NewProject
import ai.BzAnalytics.dao.ProjectRequirement
import ai.BzAnalytics.dao.Technology
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

@Serializable
class ProjectRequirementService {
    fun getAllProjectRequirements(): Map<Int, ai.BzAnalytics.entities.ProjectRequirement> {
        return transaction {
            ProjectRequirement.selectAll().associate {
                val skillId = it[ProjectRequirement.id].value
                val skill = Technology.select { Technology.id eq skillId }
                    .single().let { tech ->
                        ai.BzAnalytics.entities.Technology(skillId, tech[Technology.name])
                    }

                it[ProjectRequirement.id].value to ai.BzAnalytics.entities.ProjectRequirement(
                    skill,
                    it[ProjectRequirement.count]
                )
            }.toMap()
        }
    }
}