package ai.BzAnalytics.service

import ai.BzAnalytics.dao.Employee
import ai.BzAnalytics.dao.Project
import ai.BzAnalytics.dao.ProjectAllocation
import ai.BzAnalytics.dao.Technology
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter

@Serializable
class EmployeeService {
    fun getAllEmployees(): Map<Int, ai.BzAnalytics.entities.Employee> {
        return transaction {
            (Employee innerJoin ProjectAllocation)
                .slice(
                    Employee.employeeId, Employee.firstName, Employee.lastName, Employee.primarySkill, Employee.secondarySkill,
                    Employee.startDate, Employee.endDate, ProjectAllocation.employee, ProjectAllocation.project,
                    maxOf(ProjectAllocation.startMonth), maxOf(ProjectAllocation.startYear), ProjectAllocation.endMonth, ProjectAllocation.endYear
                )
                .selectAll()
                .associate {
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

                    val projectId = it[ProjectAllocation.project]
                    val project = Project.select { Project.projectId eq projectId }
                        .single().let { proj ->
                            ai.BzAnalytics.entities.Project(projectId, proj[Project.name])
                        }

                    val startDate = it[Employee.startDate]
                    val endDate = it[Employee.endDate]
                    val todayDate = LocalDate.now()

                    val dateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
                    val formattedTodayDate: String = todayDate.format(dateFormatter)

                    val experience = if (endDate.contentEquals("undefined")) {
                        val from = LocalDate.parse(startDate, dateFormatter)
                        val to = LocalDate.parse(formattedTodayDate, dateFormatter)
                        val period = Period.between(from, to)
                        period.years * 12 + period.months
                    } else {
                        val from = LocalDate.parse(startDate, dateFormatter)
                        val to = LocalDate.parse(endDate, dateFormatter)
                        val period = Period.between(from, to)
                        period.years * 12 + period.months
                    }

                    it[Employee.employeeId] to ai.BzAnalytics.entities.Employee(
                        it[Employee.employeeId],
                        it[Employee.firstName],
                        it[Employee.lastName],
                        primarySkill,
                        secondarySkill,
                        project,
                        experience
                    )
                }
        }
    }

    fun getAllCurrentEmployees(): Map<Int, ai.BzAnalytics.entities.EmployeeCurrent> {
        return transaction {
            (Employee innerJoin ProjectAllocation)
                .slice(
                    Employee.employeeId, Employee.firstName, Employee.lastName, Employee.primarySkill, Employee.secondarySkill,
                    Employee.startDate, Employee.endDate, ProjectAllocation.employee, ProjectAllocation.project,
                    maxOf(ProjectAllocation.startMonth), maxOf(ProjectAllocation.startYear), ProjectAllocation.endMonth, ProjectAllocation.endYear
                )
                .select{ (Employee.startDate neq "undefined") and  (Employee.endDate eq "undefined")  }
                .associate {

                    val projectId = it[ProjectAllocation.project]
                    val project = Project.select { Project.projectId eq projectId }
                        .single().let { proj ->
                            ai.BzAnalytics.entities.Project(projectId, proj[Project.name])
                        }

                    val startDate = it[Employee.startDate]
                    val endDate = it[Employee.endDate]
                    val todayDate = LocalDate.now()

                    val dateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
                    val formattedTodayDate: String = todayDate.format(dateFormatter)

                    val experience = if (endDate.contentEquals("undefined")) {
                        val from = LocalDate.parse(startDate, dateFormatter)
                        val to = LocalDate.parse(formattedTodayDate, dateFormatter)
                        val period = Period.between(from, to)
                        period.years * 12 + period.months
                    } else {
                        val from = LocalDate.parse(startDate, dateFormatter)
                        val to = LocalDate.parse(endDate, dateFormatter)
                        val period = Period.between(from, to)
                        period.years * 12 + period.months
                    }

                    it[Employee.employeeId] to ai.BzAnalytics.entities.EmployeeCurrent(
                        it[Employee.employeeId],
                        it[Employee.firstName],
                        it[Employee.lastName],
                        project,
                        experience
                    )
                }
        }
    }

    fun getAllAllocatedEmployees(): Map<Int, ai.BzAnalytics.entities.EmployeeCurrent> {
        return transaction {
            (Employee innerJoin ProjectAllocation)
                .slice(
                    Employee.employeeId, Employee.firstName, Employee.lastName, Employee.primarySkill, Employee.secondarySkill,
                    Employee.startDate, Employee.endDate, ProjectAllocation.employee, ProjectAllocation.project,
                    ProjectAllocation.endMonth, ProjectAllocation.endYear
                )
                .select{ (Employee.startDate neq "undefined") and  (Employee.endDate eq "undefined") and
                        (ProjectAllocation.endMonth eq null) and(ProjectAllocation.endYear eq null)  }
                .associate {
                    val projectId = it[ProjectAllocation.project]
                    val project = Project.select { Project.projectId eq projectId }
                        .single().let { proj ->
                            ai.BzAnalytics.entities.Project(projectId, proj[Project.name])
                        }

                    val startDate = it[Employee.startDate]
                    val endDate = it[Employee.endDate]
                    val todayDate = LocalDate.now()

                    val dateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
                    val formattedTodayDate: String = todayDate.format(dateFormatter)

                    val experience = if (endDate.contentEquals("undefined")) {
                        val from = LocalDate.parse(startDate, dateFormatter)
                        val to = LocalDate.parse(formattedTodayDate, dateFormatter)
                        val period = Period.between(from, to)
                        period.years * 12 + period.months
                    } else {
                        val from = LocalDate.parse(startDate, dateFormatter)
                        val to = LocalDate.parse(endDate, dateFormatter)
                        val period = Period.between(from, to)
                        period.years * 12 + period.months
                    }

                    it[Employee.employeeId] to ai.BzAnalytics.entities.EmployeeCurrent(
                        it[Employee.employeeId],
                        it[Employee.firstName],
                        it[Employee.lastName],
                        project,
                        experience
                    )
                }
        }
    }

    fun getAllUnAllocatedEmployees(): Map<Int, ai.BzAnalytics.entities.EmployeeUnAllocated> {
        return transaction {
            (Employee innerJoin ProjectAllocation)
                .slice(
                    Employee.employeeId, Employee.firstName, Employee.lastName, Employee.primarySkill, Employee.secondarySkill,
                    Employee.startDate, Employee.endDate, ProjectAllocation.employee, ProjectAllocation.project,
                    ProjectAllocation.endMonth, ProjectAllocation.endYear
                )
                .select{ (Employee.startDate neq "undefined") and  (Employee.endDate eq "undefined") and
                        (ProjectAllocation.endMonth neq null) and(ProjectAllocation.endYear neq null)  }
                .associate {
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

                    val startDate = it[Employee.startDate]
                    val endDate = it[Employee.endDate]
                    val todayDate = LocalDate.now()

                    val dateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
                    val formattedTodayDate: String = todayDate.format(dateFormatter)

                    val experience = if (endDate.contentEquals("undefined")) {
                        val from = LocalDate.parse(startDate, dateFormatter)
                        val to = LocalDate.parse(formattedTodayDate, dateFormatter)
                        val period = Period.between(from, to)
                        period.years * 12 + period.months
                    } else {
                        val from = LocalDate.parse(startDate, dateFormatter)
                        val to = LocalDate.parse(endDate, dateFormatter)
                        val period = Period.between(from, to)
                        period.years * 12 + period.months
                    }

                    it[Employee.employeeId] to ai.BzAnalytics.entities.EmployeeUnAllocated(
                        it[Employee.employeeId],
                        it[Employee.firstName],
                        it[Employee.lastName],
                        primarySkill,
                        secondarySkill,
                        experience
                    )
                }
        }
    }
}

