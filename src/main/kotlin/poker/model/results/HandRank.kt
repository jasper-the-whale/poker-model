package poker.model.results

import com.marcinmoskala.math.pow
import poker.model.domain.Card
import poker.model.domain.PlayerHandScore

private const val INITIAL_STRAIGHT_FLUSH_VALUE = 900_000L
private const val INITIAL_QUADRUPLE_VALUE = 800_000L
private const val INITIAL_FULL_HOUSE_VALUE = 700_000L
private const val INITIAL_FLUSH_VALUE = 600_000L
private const val INITIAL_STRAIGHT_VALUE = 500_000L
private const val INITIAL_TRIPLE_VALUE = 400_000L
private const val INITIAL_TWO_PAIR_VALUE = 300_000L
private const val INITIAL_PAIR_VALUE = 200_000L
private const val INITIAL_HIGH_CARD_VALUE = 100_000L

fun List<Card>.handRanking(): PlayerHandScore {
    return when {
        this.isStraightFlush() -> PlayerHandScore(
            getHandRating(INITIAL_STRAIGHT_FLUSH_VALUE, this),
            HandResultType.STRAIGHT_FLUSH
        )
        this.isQuadruple() -> PlayerHandScore(
            getHandRating(INITIAL_QUADRUPLE_VALUE, this),
            HandResultType.QUADRUPLE
        )
        this.isFullHouse() -> PlayerHandScore(
            getHandRating(INITIAL_FULL_HOUSE_VALUE, this),
            HandResultType.FULL_HOUSE
        )
        this.isFlush() -> PlayerHandScore(
            getHandRating(INITIAL_FLUSH_VALUE, this),
            HandResultType.FLUSH
        )
        this.isStraight() -> PlayerHandScore(
            getHandRating(INITIAL_STRAIGHT_VALUE, this),
            HandResultType.STRAIGHT
        )
        this.isTriple() -> PlayerHandScore(
            getHandRating(INITIAL_TRIPLE_VALUE, this),
            HandResultType.TRIPLE
        )
        this.isTwoPair() -> PlayerHandScore(
            getHandRating(INITIAL_TWO_PAIR_VALUE, this),
            HandResultType.TWO_PAIR
        )
        this.isPair() -> PlayerHandScore(
            getHandRating(INITIAL_PAIR_VALUE, this),
            HandResultType.PAIR
        )
        else -> PlayerHandScore(
            getHandRating(INITIAL_HIGH_CARD_VALUE, this),
            HandResultType.HIGH_CARD
        )
    }
}

private fun getHandRating(initialHandValue: Long, hand: List<Card>): Long {
    val cardsGroupedByValue = hand.groupBy { it.weight.name }.map { it.value }
    return initialHandValue + cardsGroupedByValue.map { pictureValueGroup ->
        val totalNumber = pictureValueGroup.size
        pictureValueGroup.map { card -> card.weight.valueNumber.pow(totalNumber) }.sum()
    }.sum().toLong()
}

enum class HandResultType(val resultName: String) {
    HIGH_CARD("high card"),
    PAIR("pair"),
    TWO_PAIR("two pair"),
    TRIPLE("triple"),
    STRAIGHT("straight"),
    FLUSH("flush"),
    FULL_HOUSE("full house"),
    QUADRUPLE("quadruple"),
    STRAIGHT_FLUSH("straight-flush")
}
