package results

import com.marcinmoskala.math.pow
import domain.Card

private const val INITIAL_STRAIGHT_FLUSH_VALUE = 900_000L
private const val INITIAL_QUADRUPLE_VALUE = 800_000L
private const val INITIAL_FULL_HOUSE_VALUE = 700_000L
private const val INITIAL_FLUSH_VALUE = 600_000L
private const val INITIAL_STRAIGHT_VALUE = 500_000L
private const val INITIAL_TRIPLE_VALUE = 400_000L
private const val INITIAL_TWO_PAIR_VALUE = 300_000L
private const val INITIAL_PAIR_VALUE = 200_000L
private const val INITIAL_HIGH_CARD_VALUE = 100_000L

fun List<Card>.handRanking(): Long {
    return when {
        this.isStraightFlush() -> getHandRating(INITIAL_STRAIGHT_FLUSH_VALUE, this)
        this.isQuadruple() -> getHandRating(INITIAL_QUADRUPLE_VALUE, this)
        this.isFullHouse() -> getHandRating(INITIAL_FULL_HOUSE_VALUE, this)
        this.isFlush() -> getHandRating(INITIAL_FLUSH_VALUE, this)
        this.isStraight() -> getHandRating(INITIAL_STRAIGHT_VALUE, this)
        this.isTriple() -> getHandRating(INITIAL_TRIPLE_VALUE, this)
        this.isTwoPair() -> getHandRating(INITIAL_TWO_PAIR_VALUE, this)
        this.isPair() ->getHandRating(INITIAL_PAIR_VALUE, this)
        else -> getHandRating(INITIAL_HIGH_CARD_VALUE, this)
    }
}

fun getHandRating(initialHandValue: Long, hand: List<Card>): Long {
    val cardsGroupedByValue =hand.groupBy { it.picture.name }.map { it.value }
    return cardsGroupedByValue.map { pictureValueGroup ->
        val totalNumber = pictureValueGroup.size
        pictureValueGroup.map { card ->  card.picture.valueNumber.pow(totalNumber) }.sum()
    }.sum().toLong()
}