package ai.BzAnalytics.service

import ai.BzAnalytics.dao.Employee
import ai.BzAnalytics.dao.Technology
import ai.BzAnalytics.dao.Project
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

@Serializable
class EmployeeService {
    fun getAllEmployees(): Map<Int, ai.BzAnalytics.entities.Employee> {
        return transaction {
            Employee.selectAll().associate {

                val primarySkillId = it[Employee.primarySkill]
                val primarySkill = Technology.select { Technology.id eq primarySkillId }
                    .single().let { tech ->
                        ai.BzAnalytics.entities.Technology(primarySkillId, tech[Technology.name])
                    }

                val secondarySkillId = it[Employee.secondarySkill]
                val secondarySkill = if (secondarySkillId != null) {
                    Technology.select { Technology.id eq secondarySkillId }
                        .singleOrNull()?.let { tech ->
                            ai.BzAnalytics.entities.Technology(secondarySkillId, tech[Technology.name])
                        }
                } else {
                    null
                }

                val projectId = it[Employee.project]
                val project = Project.select { Project.id eq projectId }
                    .singleOrNull()?.let { proj ->
                        ai.BzAnalytics.entities.Project(projectId, proj[Project.name])
                    }

                it[Employee.id].value to ai.BzAnalytics.entities.Employee(
                    it[Employee.id].value,
                    it[Employee.firstName],
                    it[Employee.lastName],
                    primarySkill,
                    secondarySkill,
                    project,
                    it[Employee.startDate],
                    it[Employee.endDate]
                )
            }
        }

    }

}