package ai.BzAnalytics.plugins

import ai.BzAnalytics.entities.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


fun Application.configureRouting() {

    val repositoryImpl = RepositoryImpl()

    routing {
        get("/") {
            call.respondText("<html><body><h3>Task</h3>Build a REST API service using Kotlin with following endpoints.<ol><li>An endpoint to get a list of current employees with First Name, Last Name, Current Project and Experience in months.<br><a href='/employees'>/employees</a>, <a href='/employees/current'>/employees/current</a>, <a href='/employees/allocated'>/employees/allocated</a></li>" +
            "<li>An endpoint to retrieve all currently running projects with Project Name, Start Date and List of employees working in the project.<br><a href='/projects'>/projects</a>, <a href='/projects/current'>/projects/current</a></li>" +
            "<li>An endpoint to retrieve employees who are currently unallocated with their First Name, Last Name and skills.<br><a href='/employees/unallocated'>/employees/unallocated</a></li>" +
            "<li>Given a new project requirement - skills and number of employees for each skill, the 4th endpoint should return possible employee allocations for the project. Only unallocated employees should be considered for allocation to a new project." +
                    " If there are more than one unallocated employee with the required skill make a choice based on their primary skill. Their experience working in the company shall be the second consideration.<br><a href='/technologies'>/technologies</a>, <a href='/newprojects'>/newprojects</a>, <a href='/projectrequirements'>/projectrequirements</a></li></ol></body></html>", contentType = ContentType.Text.Html)
        }
    }

    routing {
        get("/employees") {
            call.respond(repositoryImpl.getAllEmployees())
        }
    }

    routing {
        get("/employees/current") {
            call.respond(repositoryImpl.getAllCurrentEmployees())
        }
    }

    routing {
        get("/employees/allocated") {
            call.respond(repositoryImpl.getAllAllocatedEmployees())
        }
    }

    routing {
        get("/employees/unallocated") {
            call.respond(repositoryImpl.getAllUnAllocatedEmployees())
        }
    }

    routing {
        get("/projects") {
            call.respond(repositoryImpl.getAllProjects())
        }
    }

    routing {
        get("/projects/current") {
            call.respond(repositoryImpl.getAllCurrentProjects())
        }
    }

    routing {
        get("/technologies") {
            call.respond(repositoryImpl.getAllTechnologies())
        }
    }

    routing {
        get("/newprojects") {
            call.respond(repositoryImpl.getAllNewProjects())
        }
    }

    routing {
        get("/projectrequirements") {
            call.respond(repositoryImpl.getAllProjectRequirements())
        }
    }

}

