import domain.Card
import domain.Picture
import domain.Suit

private const val TOTAL_CARDS = 52
private const val TOTAL_SUITS = 4

fun main() {
    println(getShuffledDeckOfCards())
}

fun getShuffledDeckOfCards(): List<Card> =
    (0 until TOTAL_CARDS).toList().map {
        val newSuit = Suit.getSuitFromNumber(it.rem(TOTAL_SUITS))
        val newPicture = Picture.getPictureFromNumber(it.div(TOTAL_SUITS) + 2)
        Card(newSuit, newPicture)
    }.shuffled()