package day01

import day01.Day01Part01.getWordCalibrationValue
import println
import readInput

object Day01Part01 {
    fun getWordCalibrationValue(word: String): Int {
        val digitsOfWord = word.filter { it.isDigit() }
        val firstDigit = digitsOfWord.first().digitToInt()
        val lastDigit = digitsOfWord.last().digitToInt()
        return firstDigit * 10 + lastDigit
    }
}

fun main() {

    fun solveChallenge(input: List<String>): Int {

        val total = input.fold(0) { acc, word -> acc + getWordCalibrationValue(word) }

        return total
    }

    val input = readInput("day01")
    solveChallenge(input).println()
}
