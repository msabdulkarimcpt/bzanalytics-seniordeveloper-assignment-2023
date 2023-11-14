package ai.BzAnalytics.entities

//import ai.BzAnalytics.entities.Employee
//import org.jetbrains.exposed.dao.id.get
import ai.BzAnalytics.service.EmployeeService
import kotlinx.serialization.Serializable

@Serializable
sealed interface Repository {
    //fun getAllTechnologies(): Map<Int, Technology>
    fun getAllEmployees(): Map<Int, Employee>
    //fun getAllCurrentEmployees(): Map<Int, Employee>
    //fun getAllProjects(): Map<Int, Project>

}
@Serializable
class RepositoryImpl : Repository {
    //private val employeeService : EmployeeService,
    //private val technologyService : TechnologyService,
    //private val projectService : ProjectService
    //)
    private val employeeService = EmployeeService()
    //override fun getAllTechnologies(): Map<Int, Technology> {
    //    return technologyService.getAllTechnologies()
    //}
    override fun getAllEmployees(): Map<Int, Employee> {
        return employeeService.getAllEmployees()
    }

    //override fun getAllCurrentEmployees(): Map<Int, Employee> {
    //    return employeeService.getAllCurrentEmployees()
    //}

    //override fun getAllProjects(): Map<Int, Project> {
    //    return projectService.getAllProjects()
    //}
}



