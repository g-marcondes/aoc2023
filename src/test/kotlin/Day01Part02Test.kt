
import day01.Day01Part02.getWordCalibrationValue
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class Day01Part02Test {

    @ParameterizedTest
    @CsvSource( "1abc2,12","pqr3stu8vwx,38","a1b2c3d4e5f,15","treb7uchet,77" )
    fun shouldGetWordCalibrationValueWithoutNamedDigits (word: String, expectedValue: Int) {
        // GIVEN / WHEN
        val result: Int = getWordCalibrationValue(word)

        // THEN
        assertEquals(expectedValue, result)
    }

    @ParameterizedTest
    @CsvSource(
        "two1nine,29",
        "eightwothree,83",
        "abcone2threexyz,13",
        "xtwone3four,24",
        "4nineeightseven2,42",
        "zoneight234,14",
        "7pqrstsixteen, 76",
        "one2one,11"
    )
    fun shouldGetWordCalibrationValueWithNamedDigits (word: String, expectedValue: Int) {
        // GIVEN / WHEN
        val result: Int = getWordCalibrationValue(word)

        // THEN
        assertEquals(expectedValue, result)
    }
}