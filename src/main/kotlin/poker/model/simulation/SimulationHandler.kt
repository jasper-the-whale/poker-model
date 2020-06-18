package poker.model.simulation

import poker.model.domain.ApiResponse
import poker.model.domain.Card
import poker.model.domain.Suit
import poker.model.domain.Weight

fun calculateOutcomeProbabilities(
    totalSims: Long,
    totalPlayers: Int,
    pot: Long,
    betToLose: Long,
    myCards: List<Card>,
    tableCards: List<Card>
): ApiResponse {
    val deck: List<Card> = getDeckOfCards().filter { !myCards.contains(it) && !tableCards.contains(it) }
    val sim = getSimulatedMatches(totalSims, totalPlayers, deck, myCards, tableCards)

    return getMatchSummary(sim, pot, betToLose)
}

private fun getDeckOfCards(): List<Card> {
    val totalCards = 52
    val totalSuits = 4
    return (0 until totalCards).toList().map {
        val newSuit =
            Suit.getSuitFromNumber(it.rem(totalSuits))
        val newPicture =
            Weight.getValueFromNumber(it.div(totalSuits) + 2)
        Card(newSuit, newPicture)
    }
}
