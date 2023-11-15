package ai.BzAnalytics.usecases

import ai.BzAnalytics.entities.ProjectRequirement
import ai.BzAnalytics.entities.Employee
import ai.BzAnalytics.entities.NewProject
import ai.BzAnalytics.entities.Project
import ai.BzAnalytics.entities.Technology
import ai.BzAnalytics.service.*

class UseCases {
    fun task1(): Map<Int,Employee> {
        // Implement task 1 logic here
        val employeeService = EmployeeService()
        val result = employeeService.getAllEmployees()
        return if (result.isNotEmpty()) {
            result
        } else {
            emptyMap<Int,Employee>()
        }
    }



    fun task2(): Map<Int, Any> {
        // Implement task 2 logic here
        val projectService = ProjectService()
        val result = projectService.getAllProjects()
        return if (result.isNotEmpty()) {
            result
        } else {
            emptyMap<Int,Project>()
        }
    }


    fun task3(): Map<Int,Technology> {
        // Implement task 3 logic here
        val technologyService = TechnologyService()
        val result = technologyService.getAllTechnologies()
        return if (result.isNotEmpty()) {
            result
        } else {
            emptyMap<Int,Technology>()
        }
    }

    fun task4(): Map<Int,NewProject> {
        // Implement task 4 logic here
        val newProjectService = NewProjectService()
        val result = newProjectService.getAllNewProjects()
        return if (result.isNotEmpty()) {
            result
        } else {
            emptyMap<Int,NewProject>()
        }
    }

    fun task5(): Map<Int,ProjectRequirement> {
        // Implement task 5 logic here
        val projectRequirementService = ProjectRequirementService()
        val result = projectRequirementService.getAllProjectRequirements()
        return if (result.isNotEmpty()) {
            result
        } else {
            emptyMap<Int,ProjectRequirement>()
        }
    }
}