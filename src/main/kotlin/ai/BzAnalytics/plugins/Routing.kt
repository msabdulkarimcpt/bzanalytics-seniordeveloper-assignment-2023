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
            call.respondText("""{"message": "The API successfully recognized you as an admin."}""", contentType = ContentType.Application.Json)
        }
    }

    routing {
        get("/employees") {
            //println(repositoryImpl.getAllEmployees())
            call.respond(repositoryImpl.getAllEmployees())
            //call.respondText("Hello Hello World!")
            //val myMap = mutableMapOf<Int, Technology>()
            //myMap[1]= Technology(1,"ABC")
            //myMap[2]= Technology(2,"DEF")
            //myMap[3]= Technology(3,"GHI")
            //val abc = Technology(3,"KLM")
            //val jsonString = Json.encodeToString(abc)
            //call.respond(myMap)


        }
    }

}

