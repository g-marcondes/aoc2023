
import day01.Day01Part01.getWordCalibrationValue
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class Day01Part01Test {

    @ParameterizedTest
    @CsvSource( "1abc2,12","pqr3stu8vwx,38","a1b2c3d4e5f,15","treb7uchet,77" )
    fun shouldGetWordCalibrationValue (word: String, expectedValue: Int) {
        // GIVEN

        // WHEN
        val result: Int = getWordCalibrationValue(word)

        // THEN
        assertEquals(expectedValue, result)
    }
}