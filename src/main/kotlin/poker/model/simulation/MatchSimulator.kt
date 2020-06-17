package poker.model.simulation

import poker.model.domain.Card
import poker.model.domain.PlayerHands
import poker.model.domain.TableOutcome
import poker.model.results.handRanking

private const val MAX_TABLE_CARDS = 5

fun matchSimulator(
    totalSims: Long,
    myCards: List<Card>,
    deck: List<Card>,
    tableCards: List<Card>,
    totalPlayers: Int
): List<TableOutcome> =
    (0 until totalSims).toList().map {
        val simulatedGame = getSimulatedTable(myCards, deck, tableCards, totalPlayers)
        TableOutcome(
            simulatedGame.isMyHandBest(),
            simulatedGame.myHand.handRanking().handType
        )
    }

private fun getSimulatedTable(
    myCards: List<Card>,
    deck: List<Card>,
    tableCards: List<Card>,
    totalPlayers: Int
): PlayerHands {
    val shuffledDeck = deck.shuffled()
    val extraTableCards = (0 until MAX_TABLE_CARDS - tableCards.size).toList()
        .map { shuffledDeck[it] }
    val table = tableCards.plus(extraTableCards)

    //println("My hand score is: $myHandScore")
    val otherPlayerHands = (0 until totalPlayers).toList()
        .map {
            listOf(
                shuffledDeck[2 * it + MAX_TABLE_CARDS - tableCards.size],
                shuffledDeck[2 * it + MAX_TABLE_CARDS - tableCards.size + 1]
            ).plus(table)
        }
    return PlayerHands(myCards.plus(table), otherPlayerHands)
}

private fun PlayerHands.isMyHandBest(): Boolean {
    val otherPlayerRanks = this.otherHands.map { it.handRanking() }
    val myHandRanking = this.myHand.handRanking()
    return !otherPlayerRanks.any { it.handScore > myHandRanking.handScore }
}

