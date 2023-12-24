package day04

import challenges.adventofcode2023.day02.Colors
import challenges.adventofcode2023.day02.RGBGame
import challenges.adventofcode2023.day02.RGBSet
import day02.Day02Part02.getColorFromLine
import day04.Day04Part02.getWinningNumbersCount
import day04.Day04Part02.solveChallenge
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource

internal class Day04Part02Test {
    companion object{
        @JvmStatic
        private fun getCards(): List<Arguments> = listOf(
            Arguments.of(listOf(1,2), listOf(3), 0),
            Arguments.of(listOf(1,2), listOf(1), 1),
            Arguments.of(listOf(1,2), listOf(1,2), 2),
            Arguments.of(listOf(1,2,3,4), listOf(4,2), 2),
            Arguments.of(listOf(1,2,3,4,5), listOf(1,2,5,6), 3),
        )
    }

    @ParameterizedTest
    @MethodSource("getCards")
    fun testCountOfWinningNumbers(winningNumbers: List<Int>, numbers: List<Int>, expectedPoints: Int) {
        // GIVEN

        // WHEN
        val result: Int = getWinningNumbersCount(winningNumbers, numbers)

        // THEN
        assertEquals(expectedPoints, result)
    }


    @Test
    fun testChallenge() {
        // GIVEN
        val cards = listOf(
            "Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53",
            "Card 2: 13 32 20 16 61 | 61 30 68 82 17 32 24 19",
            "Card 3:  1 21 53 59 44 | 69 82 63 72 16 21 14  1",
            "Card 4: 41 92 73 84 69 | 59 84 76 51 58  5 54 83",
            "Card 5: 87 83 26 28 32 | 88 30 70 12 93 22 82 36",
            "Card 6: 31 18 13 56 72 | 74 77 10 23 35 67 36 11"
        )
        val expectedTotal = 30

        val result: Int = solveChallenge(cards)

        // THEN
        assertEquals(expectedTotal, result)
    }
}