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

enum class Picture(val picturesNumber: Int, val pictureString: String) {
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
        fun getPictureFromNumber(number: Int): Picture =
            values().first { it.picturesNumber == number }
    }
}

fun Int.isJoinedBelowBy(anotherCardNumber: Int): Boolean =
    this - anotherCardNumber == 1

fun Int.isJoinedAboveBy(anotherCardNumber: Int): Boolean =
    anotherCardNumber - this == 1
