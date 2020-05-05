import domain.Card
import domain.Value
import domain.Suit

private const val TOTAL_CARDS = 52
private const val TOTAL_SUITS = 4

fun main() {
    println(getDeckOfCards())
}

fun getDeckOfCards(): List<Card> =
    (0 until TOTAL_CARDS).toList().map {
        val newSuit = Suit.getSuitFromNumber(it.rem(TOTAL_SUITS))
        val newPicture = Value.getValueFromNumber(it.div(TOTAL_SUITS) + 2)
        Card(newSuit, newPicture)
    }