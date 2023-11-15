package ai.BzAnalytics.service

import ai.BzAnalytics.dao.Technology
import kotlinx.serialization.Serializable
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

@Serializable
class TechnologyService {
    fun getAllTechnologies(): Map<Int, ai.BzAnalytics.entities.Technology> {
        return transaction {
            Technology.selectAll().associate {
                    it[Technology.id].value to ai.BzAnalytics.entities.Technology(
                        it[Technology.id].value,
                        it[Technology.name]
                    )
                }.toMap()
        }
    }
}