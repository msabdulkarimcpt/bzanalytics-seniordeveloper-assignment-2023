package ai.BzAnalytics.dao

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.*

object DatabaseFactory {
    fun init() {
        // for db connection
        Database.connect(
            url = "jdbc:mysql://localhost:3306/akms",
            driver = "com.mysql.cj.jdbc.Driver",
            user = "root",
            password = "Mysql@123"
        )
        //creating tables
        transaction {
            SchemaUtils.create(Employee,Project,ProjectAllocation,Technology, ProjectRequirement, NewProject)

        }
    }
}