package day02

import challenges.adventofcode2023.day02.Colors
import challenges.adventofcode2023.day02.RGBBag
import challenges.adventofcode2023.day02.RGBGame
import challenges.adventofcode2023.day02.RGBSet
import day02.Day02Part01.getColorFromLine
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource

internal class Day02Part01Test {
    private val bag = RGBBag(12,13,14)

    companion object {
        @JvmStatic
        private fun getValidGames(): List<Arguments> {
            return listOf(
                Arguments.of(
                    RGBGame(1, listOf(
                        RGBSet(4,3,0),
                        RGBSet(1,2,6),
                        RGBSet(0,2,0)
                    ))
                ),
                Arguments.of(
                    RGBGame(2, listOf(
                        RGBSet(0,2,1),
                        RGBSet(1,3,4),
                        RGBSet(0,1,1)
                    ))
                ),
                Arguments.of(
                    RGBGame(3, listOf(
                        RGBSet(6,3,1),
                        RGBSet(1,2,2)
                    ))
                )
            )
        }

        @JvmStatic
        private fun getInvalidGames(): List<Arguments> {
            return listOf(
                Arguments.of(
                    RGBGame(3, listOf(
                        RGBSet(20,8,6),
                        RGBSet(4,13,5),
                        RGBSet(1,5,0)
                    ))
                ),
                Arguments.of(
                    RGBGame(4, listOf(
                        RGBSet(3,1,6),
                        RGBSet(6,3,0),
                        RGBSet(14,3,15)
                    ))
                )
            )

        }
    }

    @ParameterizedTest
    @MethodSource("getValidGames")
    fun shouldBeAValidGame(game: RGBGame) {
        // GIVEN / WHEN
        val result: Boolean = game.isValid(bag)

        // THEN
        assertTrue(result)
    }

    @ParameterizedTest
    @MethodSource("getInvalidGames")
    fun shouldBeAnInvalidGame(game: RGBGame) {
        // GIVEN / WHEN
        val result: Boolean = game.isValid(bag)

        // THEN
        assertFalse(result)
    }

    @ParameterizedTest
    @CsvSource(
        "12 blue; 0; 0; 12",
        "1 green, 13 red; 13; 1; 0",
        "9 blue, 2 red, 5 green; 2; 5; 9",
        "3 blue, 4 red; 4; 0; 3",
        "1 red, 2 green, 6 blue; 1; 2; 6",
        "2 green; 0; 2; 0"
    , delimiter = ';')
    fun getColorFromLineTest(line: String, expectedRed: Int, expectedGreen: Int, expectedBlue: Int) {
        // GIVEN

        // WHEN
        val red = getColorFromLine(Colors.RED.name, line)
        val green = getColorFromLine(Colors.GREEN.name, line)
        val blue = getColorFromLine(Colors.BLUE.name, line)

        // THEN
        assertEquals(red, expectedRed)
        assertEquals(green, expectedGreen)
        assertEquals(blue, expectedBlue)
    }
}