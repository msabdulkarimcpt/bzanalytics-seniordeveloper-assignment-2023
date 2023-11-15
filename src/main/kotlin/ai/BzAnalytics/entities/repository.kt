package ai.BzAnalytics.entities

import ai.BzAnalytics.service.*
import kotlinx.serialization.Serializable

@Serializable
sealed interface Repository {
    fun getAllTechnologies(): Map<Int, Technology>
    fun getAllEmployees(): Map<Int, Employee>
    fun getAllCurrentEmployees(): Map<Int, EmployeeCurrent>
    fun getAllAllocatedEmployees(): Map<Int, EmployeeCurrent>
    fun getAllUnAllocatedEmployees(): Map<Int, EmployeeUnAllocated>
    fun getAllProjects(): Map<Int, Project>
    fun getAllCurrentProjects(): Map<Int, ProjectCurrent>
    fun getAllNewProjects(): Map<Int, NewProject>
    fun getAllProjectRequirements(): Map<Int, ProjectRequirement>

}
@Serializable
class RepositoryImpl : Repository {

    private val employeeService = EmployeeService()
    private val projectService = ProjectService()
    private val technologyService = TechnologyService()
    private val newProjectService = NewProjectService()
    private val projectRequirementService = ProjectRequirementService()
    override fun getAllTechnologies(): Map<Int, Technology> {
        return technologyService.getAllTechnologies()
    }
    override fun getAllEmployees(): Map<Int, Employee> {
        return employeeService.getAllEmployees()
    }
    override fun getAllCurrentEmployees(): Map<Int, EmployeeCurrent> {
        return employeeService.getAllCurrentEmployees()
    }
    override fun getAllAllocatedEmployees(): Map<Int, EmployeeCurrent> {
        return employeeService.getAllAllocatedEmployees()
    }
    override fun getAllUnAllocatedEmployees(): Map<Int, EmployeeUnAllocated> {
        return employeeService.getAllUnAllocatedEmployees()
    }
    override fun getAllProjects(): Map<Int, Project> {
        return projectService.getAllProjects()
    }

    override fun getAllCurrentProjects(): Map<Int, ProjectCurrent> {
        return projectService.getAllCurrentProjects()
    }

    override fun getAllNewProjects(): Map<Int, NewProject> {
        return newProjectService.getAllNewProjects()
    }
    override fun getAllProjectRequirements(): Map<Int, ProjectRequirement> {
        return projectRequirementService.getAllProjectRequirements()
    }

}



