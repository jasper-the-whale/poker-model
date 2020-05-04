package results

import domain.Card
import domain.Suit

//Will take a list of cards and returns true if there is a pair of cards that match
fun List<Card>.isPair(): Boolean =
    this.map { it.pictures }.distinct().size != this.size

fun List<Card>.isFlush(): Boolean =
    when {
        this.filter { it.suit == Suit.HEART }.size == 5 -> true
        this.filter { it.suit == Suit.DIAMOND }.size == 5 -> true
        this.filter { it.suit == Suit.SPADE }.size == 5 -> true
        this.filter { it.suit == Suit.CLUB }.size == 5 -> true
        else -> false
    }
