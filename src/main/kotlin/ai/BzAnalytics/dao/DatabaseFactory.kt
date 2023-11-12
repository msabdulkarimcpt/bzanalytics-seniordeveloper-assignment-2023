package ai.BzAnalytics.dao

import kotlinx.coroutines.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.*
import org.jetbrains.exposed.sql.transactions.experimental.*

object DatabaseFactory {
    fun init() {
        //val jdbcURL = "jdbc:mysql://root:Mysql@123@localhost:3306/akms?useUnicode=true&serverTimezone=UTC"
        //val driverClassName = "com.mysql.cj.jdbc.Driver"
        //val driverClassName = "org.h2.Driver"
        //val jdbcURL = "jdbc:h2:file:./build/db"
        //jdbcURL = "jdbc:mysql://localhost:3306/akms"
        //driverClassName = "com.mysql.cj.jdbc.Driver"
        //user = "root"
        //password = "Mysql@123"
        //val database = Database.connect(jdbcURL, driverClassName)
        //transaction(database) {
            //SchemaUtils.create(Articles)
        //}
        Database.connect(
            url = "jdbc:mysql://localhost:3306/akms",
            driver = "com.mysql.cj.jdbc.Driver",
            user = "root",
            password = "Mysql@123"
        )

        transaction {
            SchemaUtils.create(Employee)
        }
    }
}