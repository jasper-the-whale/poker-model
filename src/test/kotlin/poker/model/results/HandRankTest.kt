package poker.model.results

import poker.model.domain.Card
import poker.model.domain.Weight
import poker.model.domain.Suit
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class HandRankTest {

    @Nested
    inner class handRanking {

        @Test
        fun `should return value for a pair`(){
            val aHand = listOf<Card>(
                Card(Suit.SPADE, Weight.TEN),
                Card(Suit.HEART, Weight.TEN),
                Card(Suit.DIAMOND, Weight.FOUR),
                Card(Suit.DIAMOND, Weight.FIVE),
                Card(Suit.CLUB, Weight.TWO),
                Card(Suit.CLUB, Weight.THREE),
                Card(Suit.CLUB, Weight.QUEEN)
            )
        }
    }

}