package results

import domain.Card
import domain.Value
import domain.Suit
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class HandResultsTest {
    private val muckHand = listOf<Card>(
        Card(Suit.SPADE, Value.TEN),
        Card(Suit.HEART, Value.KING),
        Card(Suit.DIAMOND, Value.FOUR),
        Card(Suit.DIAMOND, Value.FIVE),
        Card(Suit.CLUB, Value.TWO),
        Card(Suit.CLUB, Value.THREE),
        Card(Suit.CLUB, Value.QUEEN)
    )

    @Nested
    inner class isPair {
        @Test
        fun `should return true when there is a pair`() {
            val aHand = listOf<Card>(
                Card(Suit.SPADE, Value.TEN),
                Card(Suit.HEART, Value.TEN),
                Card(Suit.DIAMOND, Value.FOUR),
                Card(Suit.DIAMOND, Value.FIVE),
                Card(Suit.CLUB, Value.TWO),
                Card(Suit.CLUB, Value.THREE),
                Card(Suit.CLUB, Value.QUEEN)
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
                Card(Suit.DIAMOND, Value.FOUR),
                Card(Suit.DIAMOND, Value.FIVE),
                Card(Suit.CLUB, Value.TEN),
                Card(Suit.CLUB, Value.JACK),
                Card(Suit.CLUB, Value.TWO),
                Card(Suit.CLUB, Value.THREE),
                Card(Suit.CLUB, Value.QUEEN)
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
                Card(Suit.SPADE, Value.JACK),
                Card(Suit.HEART, Value.NINE),
                Card(Suit.DIAMOND, Value.TEN),
                Card(Suit.DIAMOND, Value.EIGHT),
                Card(Suit.CLUB, Value.QUEEN),
                Card(Suit.CLUB, Value.TWO),
                Card(Suit.CLUB, Value.TEN)
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
                Card(Suit.SPADE, Value.JACK),
                Card(Suit.SPADE, Value.NINE),
                Card(Suit.DIAMOND, Value.TEN),
                Card(Suit.SPADE, Value.EIGHT),
                Card(Suit.SPADE, Value.QUEEN),
                Card(Suit.CLUB, Value.TWO),
                Card(Suit.SPADE, Value.TEN)
            )

            assertEquals(true, aHand.isStraightFlush())
        }

        @Test
        fun `should return false when there is not a straight flush`() {
            assertEquals(false, muckHand.isStraightFlush())
        }
    }
}
