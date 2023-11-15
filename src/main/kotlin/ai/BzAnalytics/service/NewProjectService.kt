package ai.BzAnalytics.service

import ai.BzAnalytics.dao.*
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

@Serializable
class NewProjectService {
    fun getAllNewProjects(): Map<Int, ai.BzAnalytics.entities.NewProject> {
        return transaction {
            (ProjectRequirement innerJoin NewProject)
                .slice(
                    ProjectRequirement.id, ProjectRequirement.skill, ProjectRequirement.count,
                    NewProject.id, NewProject.name, NewProject.requirements
                )
            .selectAll().associate {

                val skillId = it[ProjectRequirement.id].value
                val skill = Technology.select { Technology.id eq skillId }
                    .single().let { tech ->
                        ai.BzAnalytics.entities.Technology(skillId, tech[Technology.name])
                    }

                val newProjectId = it[NewProject.id].value
                val projectRequirements = NewProject.select { NewProject.id eq newProjectId }
                    .map(){ _ ->
                        ai.BzAnalytics.entities.ProjectRequirement(
                            skill,
                            it[ProjectRequirement.count]
                            )
                    }

                it[NewProject.id].value to ai.BzAnalytics.entities.NewProject(
                    it[NewProject.name],
                    projectRequirements
                )
            }.toMap()
        }
    }
}