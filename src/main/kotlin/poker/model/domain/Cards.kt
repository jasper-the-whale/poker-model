package poker.model.domain

data class Card(
    val suit: Suit,
    val weight: Weight
)

enum class Suit(val suitName: String, val suitNumber: Int) {
    HEART("H", 0),
    DIAMOND("D", 1),
    SPADE("S", 2),
    CLUB("C", 3);

    companion object {
        fun getSuitFromNumber(number: Int): Suit =
            values().first { it.suitNumber == number }
    }
}

enum class Weight(val valueNumber: Int, val valueString: String) {
    TWO(2, "2"),
    THREE(3, "3"),
    FOUR(4, "4"),
    FIVE(5, "5"),
    SIX(6, "6"),
    SEVEN(7, "7"),
    EIGHT(8, "8"),
    NINE(9, "9"),
    TEN(10, "10"),
    JACK(11, "J"),
    QUEEN(12, "Q"),
    KING(13, "K"),
    ACE(14, "A");

    companion object {
        fun getValueFromNumber(number: Int): Weight =
            values().first { it.valueNumber == number }
    }
}
