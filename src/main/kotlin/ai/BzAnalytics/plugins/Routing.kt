package ai.BzAnalytics.plugins

import ai.BzAnalytics.entities.*
import ai.BzAnalytics.service.EmployeeService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.*

fun Application.configureRouting() {

    val repositoryImpl = RepositoryImpl()

    routing {
        get("/") {
            call.respondText("<html><body><h3>Task</h3>Build a REST API service using Kotlin with following endpoints.<ol><li><a href='/employees'>An endpoint to get a list of current employees with First Name, Last Name, Current Project and Experience in months.</a></li>" +
            "<li>An endpoint to retrieve all currently running projects with Project Name, Start Date and List of employees working in the project.</li>" +
            "<li>An endpoint to retrieve employees who are currently unallocated with their First Name, Last Name and skills.</li>" +
            "<li>Given a new project requirement - skills and number of employees for each skill, the 4th endpoint should return possible employee allocations for the project. Only unallocated employees should be considered for allocation to a new project." +
                    " If there are more than one unallocated employee with the required skill make a choice based on their primary skill. Their experience working in the company shall be the second consideration.</li></ol></body></html>", contentType = ContentType.Text.Html)
        }
    }

    routing {
        get("/employees") {
            call.respond(repositoryImpl.getAllEmployees())
        }
    }

}

