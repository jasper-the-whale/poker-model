import domain.Card
import domain.Picture
import domain.Suit
import results.Table

private const val TOTAL_CARDS = 52
private const val TOTAL_SUITS = 4
private const val TOTAL_OTHER_PLAYERS = 5
private const val TOTAL_SIMS = 10_000L

fun main() {
    val myHand = listOf(
        Card(Suit.SPADE, Picture.TEN),
        Card(Suit.CLUB, Picture.JACK)
    )
    val randomDeck = getDeckOfCards().filter { !myHand.contains(it) }
    val tableCards = listOf(
        Card(Suit.HEART, Picture.FOUR),
        Card(Suit.HEART, Picture.SIX),
        Card(Suit.CLUB, Picture.TEN)
    )

    val deck = getDeckOfCards().filter { !myHand.contains(it) && !tableCards.contains(it) }

    val winProb = Table(TOTAL_SIMS, myHand, deck, tableCards, TOTAL_OTHER_PLAYERS).getWinProb()
    println(winProb)
}

fun getDeckOfCards(): List<Card> =
    (0 until TOTAL_CARDS).toList().map {
        val newSuit = Suit.getSuitFromNumber(it.rem(TOTAL_SUITS))
        val newPicture = Picture.getValueFromNumber(it.div(TOTAL_SUITS) + 2)
        Card(newSuit, newPicture)
    }