package results

import domain.Card
import domain.Picture
import domain.Suit
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class HandRankTest {

    @Nested
    inner class handRanking {

        @Test
        fun `should return value for a pair`(){
            val aHand = listOf<Card>(
                Card(Suit.SPADE, Picture.TEN),
                Card(Suit.HEART, Picture.TEN),
                Card(Suit.DIAMOND, Picture.FOUR),
                Card(Suit.DIAMOND, Picture.FIVE),
                Card(Suit.CLUB, Picture.TWO),
                Card(Suit.CLUB, Picture.THREE),
                Card(Suit.CLUB, Picture.QUEEN)
            )
            println(aHand.handRanking())
        }
    }

}