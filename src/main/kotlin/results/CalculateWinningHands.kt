package results

import domain.Card
import domain.Suit

fun List<Card>.isPair(): Boolean =
    this.groupBy { it.pictures }.entries.count() <= 5

fun List<Card>.isTriple(): Boolean =
    this.groupBy { it.pictures }.entries.any { it.value.size == 3 }

fun List<Card>.isQuadruple(): Boolean =
    this.groupBy { it.pictures }.entries.any { it.value.size == 4 }

fun List<Card>.isTwoPair(): Boolean =
    this.groupBy { it.pictures }.entries.count { it.value.size == 2 } >= 2

fun List<Card>.isFullHouse(): Boolean =
    this.map { it.pictures }.distinct().size != this.size

fun List<Card>.isFlush(): Boolean =
    when {
        this.filter { it.suit == Suit.HEART }.size == 5 -> true
        this.filter { it.suit == Suit.DIAMOND }.size == 5 -> true
        this.filter { it.suit == Suit.SPADE }.size == 5 -> true
        this.filter { it.suit == Suit.CLUB }.size == 5 -> true
        else -> false
    }

