package ai.BzAnalytics
import ai.BzAnalytics.usecases.UseCases
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UseCaseTests {
    private val useCase = UseCases()
    @Test
    fun testTask1(){
        Assertions.assertEquals(13, useCase.task1().size)
    }
}