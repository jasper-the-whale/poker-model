package results

import domain.Card
import domain.Picture
import domain.Suit
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.*

internal class CalculateWinningHandsTest {
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
}
