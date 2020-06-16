package domain

data class Player (
    var cards: List<Card> = listOf(),
    var handScore: Long = 0,
    var bank: Long = 1500L
)