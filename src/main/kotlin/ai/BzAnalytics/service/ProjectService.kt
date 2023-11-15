package ai.BzAnalytics.service

import ai.BzAnalytics.dao.Employee
import ai.BzAnalytics.dao.Project
import ai.BzAnalytics.dao.ProjectAllocation
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction


@Serializable
class ProjectService {
    fun getAllProjects(): Map<Int, ai.BzAnalytics.entities.Project> {
        return transaction {
            (Project innerJoin ProjectAllocation)
                .slice(
                    Project.projectId, Project.name, ProjectAllocation.employee, ProjectAllocation.project,
                    maxOf(ProjectAllocation.startMonth), maxOf(ProjectAllocation.startYear), ProjectAllocation.endMonth, ProjectAllocation.endYear
                )
                .selectAll()
                .associate {
                    it[Project.projectId] to ai.BzAnalytics.entities.Project(
                        it[Project.projectId],
                        it[Project.name]
                    )
                }
        }
    }

    fun getAllCurrentProjects(): Map<Int, ai.BzAnalytics.entities.ProjectCurrent> {
        return transaction {
            (Project innerJoin ProjectAllocation innerJoin Employee)
                .slice(
                    Project.projectId, Project.name, Employee.employeeId, Employee.firstName, Employee.lastName, Employee.primarySkill, Employee.secondarySkill,
                    Employee.startDate, Employee.endDate, ProjectAllocation.employee, ProjectAllocation.project,
                    ProjectAllocation.startMonth, ProjectAllocation.startYear, ProjectAllocation.endMonth, ProjectAllocation.endYear
                )
                .select{ (ProjectAllocation.endMonth eq null) and(ProjectAllocation.endYear eq null)  }
                .groupBy(Employee.employeeId).associate {

                    val startDate = (it[ProjectAllocation.startMonth]).toString()+"/"+(it[ProjectAllocation.startYear]).toString()

                    val projectId = it[Project.projectId]
                    val employees = ProjectAllocation.select { ProjectAllocation.project eq projectId}
                        .map{ _ -> ai.BzAnalytics.entities.EmployeeTemp(
                            it[Employee.employeeId],
                            it[Employee.firstName],
                            it[Employee.lastName]
                        )
                    }

                    it[Project.projectId] to ai.BzAnalytics.entities.ProjectCurrent(
                        it[Project.projectId],
                        it[Project.name],
                        startDate,
                        employees
                    )
                }
        }
    }

}

