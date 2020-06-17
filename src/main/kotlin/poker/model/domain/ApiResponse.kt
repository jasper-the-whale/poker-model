package poker.model.domain

data class ApiResponse(
    val winProb: Double,
    val pairProb: Double,
    val twoPairProb: Double,
    val tripleProb: Double,
    val straightProb: Double,
    val flushProb: Double,
    val fullHouseProb: Double,
    val quadrupleProb: Double,
    val straightFlushProb: Double,
    val expectedValue: Long,
    val optimumBet: Long
)
