package ai.BzAnalytics

import ai.BzAnalytics.dao.DatabaseFactory
import ai.BzAnalytics.usecases.UseCases
import org.jetbrains.exposed.sql.Database
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UseCaseTests {
    private val useCase = UseCases()

    @BeforeAll
    fun init() {
        DatabaseFactory.init()
    }
    @Test
    fun testTask1(){
        Assertions.assertEquals(12, useCase.task1().size)
    }

    @Test
    fun testTask2(){
        Assertions.assertEquals(11, useCase.task2().size)
    }

    @Test
    fun testTask3(){
        Assertions.assertEquals(4, useCase.task3().size)
    }
    @Test
    fun testTask4(){
        Assertions.assertEquals(1, useCase.task4().size)
    }

    @Test
    fun testTask5(){
        Assertions.assertEquals(1, useCase.task5().size)
    }

}