package poker.model.domain

import poker.model.results.HandResultType

data class TableOutcome(
    val isHandWinning: Boolean,
    val myHandResult: HandResultType
)

data class PlayerHands(
    val myHand: List<Card>,
    val otherHands: List<List<Card>>
)

data class PlayerHandScore(
    val handScore: Long,
    val handType: HandResultType
)