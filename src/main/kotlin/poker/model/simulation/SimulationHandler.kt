package poker.model.simulation

import poker.model.domain.ApiResponse
import poker.model.domain.Card
import poker.model.domain.Suit
import poker.model.domain.TableOutcome
import poker.model.domain.Weight
import poker.model.results.HandResultType
import kotlin.math.roundToLong

private const val TOTAL_CARDS = 52
private const val TOTAL_SUITS = 4

private const val TOTAL_SIMS = 100_000L

fun calculateOutcomeProbs(totalPlayers: Int): ApiResponse {
    val myHand = listOf(
        Card(
            Suit.HEART,
            Weight.QUEEN
        ),
        Card(
            Suit.DIAMOND,
            Weight.QUEEN
        )
    )
    val tableCards = emptyList<Card>()
    val pot: Long = 1000
    val betToLose: Long = 200

    val deck: List<Card> = getDeckOfCards()
        .filter { !myHand.contains(it) && !tableCards.contains(it) }
    val sim = matchSimulator(TOTAL_SIMS, myHand, deck, tableCards, totalPlayers)
    val winProb = sim.map { it.isHandWinning }.count { it }.div(TOTAL_SIMS.toDouble())

    val result = ApiResponse(
        winProb = winProb,
        pairProb = sim.getProbOfHandType(HandResultType.PAIR),
        twoPairProb = sim.getProbOfHandType(HandResultType.TWO_PAIR),
        tripleProb = sim.getProbOfHandType(HandResultType.TRIPLE),
        straightProb = sim.getProbOfHandType(HandResultType.STRAIGHT),
        flushProb = sim.getProbOfHandType(HandResultType.FLUSH),
        fullHouseProb = sim.getProbOfHandType(HandResultType.FULL_HOUSE),
        quadrupleProb = sim.getProbOfHandType(HandResultType.QUADRUPLE),
        straightFlushProb = sim.getProbOfHandType(HandResultType.STRAIGHT_FLUSH),
        expectedValue = calculateExpectedValue(winProb, pot, betToLose),
        optimumBet = calculateOptimumBet(winProb, pot)
    )
    println(result)

    return result
}

private fun getDeckOfCards(): List<Card> =
    (0 until TOTAL_CARDS).toList().map {
        val newSuit =
            Suit.getSuitFromNumber(it.rem(TOTAL_SUITS))
        val newPicture =
            Weight.getValueFromNumber(it.div(TOTAL_SUITS) + 2)
        Card(newSuit, newPicture)
    }

private fun calculateExpectedValue(winProb: Double, cashToWin: Long, cashToLose: Long): Long =
    (winProb * cashToWin - (1 - winProb) * cashToLose).roundToLong()

private fun calculateOptimumBet(winProb: Double, cashToWin: Long): Long =
    (winProb * cashToWin).div(1 - winProb).roundToLong()

private fun List<TableOutcome>.getProbOfHandType(handType: HandResultType): Double =
    this.map { it.myHandResult }.count { it == handType }.div(TOTAL_SIMS.toDouble())
