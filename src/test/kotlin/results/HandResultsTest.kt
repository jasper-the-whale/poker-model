package results

import domain.Card
import domain.Picture
import domain.Suit
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test


internal class HandResultsTest {
    private val muckHand = listOf<Card>(
        Card(Suit.SPADE, Picture.TEN),
        Card(Suit.HEART, Picture.KING),
        Card(Suit.DIAMOND, Picture.FOUR),
        Card(Suit.DIAMOND, Picture.FIVE),
        Card(Suit.CLUB, Picture.TWO),
        Card(Suit.CLUB, Picture.THREE),
        Card(Suit.CLUB, Picture.QUEEN)
    )

    @Nested
    inner class isPair {
        @Test
        fun `should return true when there is a pair`() {
            val aHand = listOf<Card>(
                Card(Suit.SPADE, Picture.TEN),
                Card(Suit.HEART, Picture.TEN),
                Card(Suit.DIAMOND, Picture.FOUR),
                Card(Suit.DIAMOND, Picture.FIVE),
                Card(Suit.CLUB, Picture.TWO),
                Card(Suit.CLUB, Picture.THREE),
                Card(Suit.CLUB, Picture.QUEEN)
            )
            assertEquals(true, aHand.isPair())
        }

        @Test
        fun `should return false when there is not a pair`() {
            assertEquals(false, muckHand.isPair())
        }
    }

    @Nested
    inner class isFlush {
        @Test
        fun `should return true when there is a flush`() {
            val aHand = listOf<Card>(
                Card(Suit.DIAMOND, Picture.FOUR),
                Card(Suit.DIAMOND, Picture.FIVE),
                Card(Suit.CLUB, Picture.TEN),
                Card(Suit.CLUB, Picture.JACK),
                Card(Suit.CLUB, Picture.TWO),
                Card(Suit.CLUB, Picture.THREE),
                Card(Suit.CLUB, Picture.QUEEN)
            )
            assertEquals(true, aHand.isFlush())
        }

        @Test
        fun `should return false when there is not a flush`() {
            assertEquals(false, muckHand.isFlush())
        }
    }

    @Nested
    inner class isStraight {
        @Test
        fun `should return true when there is a straight`() {
            val aHand = listOf<Card>(
                Card(Suit.SPADE, Picture.JACK),
                Card(Suit.HEART, Picture.NINE),
                Card(Suit.DIAMOND, Picture.TEN),
                Card(Suit.DIAMOND, Picture.EIGHT),
                Card(Suit.CLUB, Picture.QUEEN),
                Card(Suit.CLUB, Picture.TWO),
                Card(Suit.CLUB, Picture.TEN)
            )

            assertEquals(true, aHand.isStraight())
        }

        @Test
        fun `should return false when there is not a straight`() {
            assertEquals(false, muckHand.isFlush())
        }
    }

    @Nested
    inner class isStraightFlush {
        @Test
        fun `should return true when there is a straight flush`() {
            val aHand = listOf<Card>(
                Card(Suit.SPADE, Picture.JACK),
                Card(Suit.SPADE, Picture.NINE),
                Card(Suit.DIAMOND, Picture.TEN),
                Card(Suit.SPADE, Picture.EIGHT),
                Card(Suit.SPADE, Picture.QUEEN),
                Card(Suit.CLUB, Picture.TWO),
                Card(Suit.SPADE, Picture.TEN)
            )

            assertEquals(true, aHand.isStraightFlush())
        }

        @Test
        fun `should return false when there is not a straight flush`() {
            assertEquals(false, muckHand.isStraightFlush())
        }
    }
}
