package results

import domain.Card

private const val TOTAL_TABLE_CARDS = 5

class Table(
    private val totalSims: Long,
    private val myCards: List<Card>,
    private val deck: List<Card>,
    private val tableCards: List<Card>,
    private val totalPlayers: Int
) {

    fun getWinProb(): Double =
        (0 until totalSims).toList().map {
            isMyHandBest()
        }.count { it }.div(totalSims.toDouble())

    private fun isMyHandBest(): Boolean {
        val shuffledDeck = deck.shuffled()
        val extraTableCards = (0 until TOTAL_TABLE_CARDS - tableCards.size).toList()
            .map { shuffledDeck[it] }
        val table = tableCards.plus(extraTableCards)
        val myHandScore = myCards.plus(table).handRanking()

        val otherPlayerHands = (0 until totalPlayers).toList()
            .map {
                listOf(
                    shuffledDeck[2 * it + TOTAL_TABLE_CARDS - tableCards.size],
                    shuffledDeck[2 * it + TOTAL_TABLE_CARDS - tableCards.size + 1]
                ).plus(table)
            }
        val otherPlayerRanks = otherPlayerHands.map {
            it.handRanking()
        }

        return !otherPlayerRanks.any { it > myHandScore }

    }

}



