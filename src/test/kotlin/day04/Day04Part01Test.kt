package day04

import day04.Day04Part01.getPoints
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class Day04Part01Test {
    companion object{
        @JvmStatic
        private fun getCards(): List<Arguments> = listOf(
            Arguments.of(listOf(1,2), listOf(3), 0),
            Arguments.of(listOf(1,2), listOf(1), 1),
            Arguments.of(listOf(1,2), listOf(1,2), 2),
            Arguments.of(listOf(1,2,3,4), listOf(4,2), 2),
            Arguments.of(listOf(1,2,3,4,5), listOf(1,2,5,6), 4),
        )
    }

    @ParameterizedTest
    @MethodSource("getCards")
    fun testCards(winningNumbers: List<Int>, numbers: List<Int>, expectedPoints: Int) {
        // GIVEN

        // WHEN
        val result: Int = getPoints(winningNumbers, numbers)

        // THEN
        assertEquals(expectedPoints, result)
    }
}