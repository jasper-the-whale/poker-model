package poker.model.results

import poker.model.domain.Card
import poker.model.domain.Weight
import poker.model.domain.Suit
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test


internal class HandResultsTest {
    private val muckHand = listOf<Card>(
        Card(Suit.SPADE, Weight.TEN),
        Card(Suit.HEART, Weight.KING),
        Card(Suit.DIAMOND, Weight.FOUR),
        Card(Suit.DIAMOND, Weight.FIVE),
        Card(Suit.CLUB, Weight.TWO),
        Card(Suit.CLUB, Weight.THREE),
        Card(Suit.CLUB, Weight.QUEEN)
    )

    @Nested
    inner class isPair {
        @Test
        fun `should return true when there is a pair`() {
            val aHand = listOf<Card>(
                Card(Suit.SPADE, Weight.TEN),
                Card(Suit.HEART, Weight.TEN),
                Card(Suit.DIAMOND, Weight.FOUR),
                Card(Suit.DIAMOND, Weight.FIVE),
                Card(Suit.CLUB, Weight.TWO),
                Card(Suit.CLUB, Weight.THREE),
                Card(Suit.CLUB, Weight.QUEEN)
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
                Card(Suit.DIAMOND, Weight.FOUR),
                Card(Suit.DIAMOND, Weight.FIVE),
                Card(Suit.CLUB, Weight.TEN),
                Card(Suit.CLUB, Weight.JACK),
                Card(Suit.CLUB, Weight.TWO),
                Card(Suit.CLUB, Weight.THREE),
                Card(Suit.CLUB, Weight.QUEEN)
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
                Card(Suit.SPADE, Weight.JACK),
                Card(Suit.HEART, Weight.NINE),
                Card(Suit.DIAMOND, Weight.TEN),
                Card(Suit.DIAMOND, Weight.EIGHT),
                Card(Suit.CLUB, Weight.QUEEN),
                Card(Suit.CLUB, Weight.TWO),
                Card(Suit.CLUB, Weight.TEN)
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
                Card(Suit.SPADE, Weight.JACK),
                Card(Suit.SPADE, Weight.NINE),
                Card(Suit.DIAMOND, Weight.TEN),
                Card(Suit.SPADE, Weight.EIGHT),
                Card(Suit.SPADE, Weight.QUEEN),
                Card(Suit.CLUB, Weight.TWO),
                Card(Suit.SPADE, Weight.TEN)
            )

            assertEquals(true, aHand.isStraightFlush())
        }

        @Test
        fun `should return false when there is not a straight flush`() {
            assertEquals(false, muckHand.isStraightFlush())
        }
    }
}
