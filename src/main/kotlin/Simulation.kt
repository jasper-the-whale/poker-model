import domain.Card
import domain.Picture
import domain.Suit
import results.Table
import kotlin.math.roundToLong

private const val TOTAL_CARDS = 52
private const val TOTAL_SUITS = 4
private const val TOTAL_OTHER_PLAYERS = 5
private const val TOTAL_SIMS = 100_000L

fun main() {
    val myHand = listOf(
        Card(Suit.HEART, Picture.QUEEN),
        Card(Suit.CLUB, Picture.SEVEN)
    )
    val tableCards = listOf(
        Card(Suit.HEART, Picture.QUEEN),
        Card(Suit.HEART, Picture.SIX),
        Card(Suit.HEART, Picture.JACK)
    )
    val pot: Long = 1000
    val betToLose: Long = 500

    val deck = getDeckOfCards().filter { !myHand.contains(it) && !tableCards.contains(it) }

    val winProb = Table(TOTAL_SIMS, myHand, deck, tableCards, TOTAL_OTHER_PLAYERS).getWinProb()
    println("Prob of hand winning is: $winProb")

    val ev = calculateExpectedValue(winProb, pot, betToLose)
    println("Expected value is: £$ev")

    val optimumBet = calculateOptimumBet(winProb, pot)
    println("Optimum bet is: £$optimumBet")
}

fun getDeckOfCards(): List<Card> =
    (0 until TOTAL_CARDS).toList().map {
        val newSuit = Suit.getSuitFromNumber(it.rem(TOTAL_SUITS))
        val newPicture = Picture.getValueFromNumber(it.div(TOTAL_SUITS) + 2)
        Card(newSuit, newPicture)
    }

fun calculateExpectedValue(winProb: Double, cashToWin: Long, cashToLose: Long): Long =
    (winProb * cashToWin - (1 - winProb) * cashToLose).roundToLong()

fun calculateOptimumBet(winProb: Double, cashToWin: Long): Long =
    (winProb * cashToWin).div(1-winProb).roundToLong()