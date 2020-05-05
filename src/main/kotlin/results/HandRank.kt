package results

import domain.Card

fun List<Card>.handRanking(): Int {
    when {
        this.isStraightFlush() -> 10
        this.isQuadruple() -> 9
        this.isFullHouse() -> 8
        this.isFlush() -> 7
        this.isStraight() -> 6
        this.isTriple() -> 5
        this.isTwoPair() -> 4
        this.isPair() ->3
        else -> 1
    }
}