package domain

data class Card(
    val suit: Suit,
    val pictures: Picture
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

enum class Picture(val picturesNumber: Int) {
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    ACE(14);

    companion object {
        fun getPictureFromNumber(number: Int): Picture =
            values().first { it.picturesNumber == number }
    }
}
