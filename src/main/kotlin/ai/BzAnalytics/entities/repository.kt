package ai.BzAnalytics.entities

interface repository {
    fun getAllTechnologies(): Map<Int, Technology>
    fun getAllEmployees(): Map<Int, Employee>
    fun getAllProjects(): Map<Int, Project>

}