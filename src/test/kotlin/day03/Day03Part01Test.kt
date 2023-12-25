package day03

import day03.Day03Part01.isSymbol
import day03.Day03Part01.isSymbolAdjacent
import day03.Day03Part01.solveChallenge
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource

class Day03Part01Test {
    companion object{
        @JvmStatic
        private fun adjacentSymbols(): List<Arguments> = listOf(
            Arguments.of(0, 0, listOf("..", ".."), false),
            Arguments.of(0, 0, listOf(".*", ".."), true),
            Arguments.of(0, 0, listOf("..", "?."), true),
            Arguments.of(0, 0, listOf("..", "./"), true),
            Arguments.of(0, 1, listOf("..", "./"), true),
            Arguments.of(0, 1, listOf("..", "%."), true),
            Arguments.of(0, 1, listOf("^.", ".."), true),
            Arguments.of(1, 0, listOf("&.", ".."), true),
            Arguments.of(1, 0, listOf(".)", ".."), true),
            Arguments.of(1, 0, listOf("..", ".("), true),
            Arguments.of(1, 1, listOf("..", "-."), true),
            Arguments.of(1, 1, listOf(".!", ".."), true),
            Arguments.of(1, 1, listOf("+.", ".."), true),
            Arguments.of(0, 5, listOf(
                "467..114..",
                "...*......",
                "..35..633.",
                "......#...",
                "617*......",
                ".....+.58.",
                "..592.....",
                "......755.",
                "...$.*....",
                ".664.598.."), false),
            Arguments.of(0, 6, listOf(
                "467..114..",
                "...*......",
                "..35..633.",
                "......#...",
                "617*......",
                ".....+.58.",
                "..592.....",
                "......755.",
                "...$.*....",
                ".664.598.."), false),
            Arguments.of(0, 7, listOf(
                "467..114..",
                "...*......",
                "..35..633.",
                "......#...",
                "617*......",
                ".....+.58.",
                "..592.....",
                "......755.",
                "...$.*....",
                ".664.598.."), false),
            Arguments.of(5, 7, listOf(
                "467..114..",
                "...*......",
                "..35..633.",
                "......#...",
                "617*......",
                ".....+.58.",
                "..592.....",
                "......755.",
                "...$.*....",
                ".664.598.."), false),
            Arguments.of(5, 8, listOf(
                "467..114..",
                "...*......",
                "..35..633.",
                "......#...",
                "617*......",
                ".....+.58.",
                "..592.....",
                "......755.",
                "...$.*....",
                ".664.598.."), false),
        )

        @JvmStatic
        private fun engine(): List<Arguments> = listOf(
            Arguments.of(listOf("..", ".."), 0),
            Arguments.of(listOf("2.", ".."), 0),
            Arguments.of(listOf("2&", ".."), 2),
            Arguments.of(listOf("21", ".)"), 21),
            Arguments.of(listOf(
                "467..114..",
                "...*......",
                "..35..633.",
                "......#...",
                "617*......",
                ".....+.58.",
                "..592.....",
                "......755.",
                "...$.*....",
                ".664.598.."),
                4361),
        )
    }
    @ParameterizedTest
    @MethodSource("engine")
    fun testEngines(input: List<String>, expectedParts: Int) {
        // GIVEN / WHEN
        val result: Int = solveChallenge(input)

        // THEN
        assertEquals(expectedParts, result)
    }

    @ParameterizedTest
    @MethodSource("adjacentSymbols")
    fun isSymbolAdjacentTest(row: Int, column: Int, input: List<String>, isSymbolAdjacent: Boolean) {
        // GIVEN / WHEN
        val result = isSymbolAdjacent(row, column, input)

        // THEN
        assertEquals(isSymbolAdjacent, result)
    }

    @ParameterizedTest
    @CsvSource("A,false", ".,false", "?,true", "2,false")
    fun isSymbolTest(char: Char, isSymbol: Boolean) {
        // GIVEN / WHEN
        val result = isSymbol(char)

        // THEN
        assertEquals(isSymbol, result)
    }
}