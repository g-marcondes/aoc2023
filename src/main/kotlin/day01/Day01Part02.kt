package day01

import day01.Day01Part02.solveChallenge
import println
import readInput

object Day01Part02 {
    fun getWordCalibrationValue(word: String): Int {
        val fixedWord = DIGITS.values().fold(word) { acc, digit ->
            val newValue = "${digit.name}${digit.numberAsString}${digit.name}"
            acc.replace(digit.name, newValue, true)
        }
        val digitsOfWord = fixedWord.filter { it.isDigit() }
        val firstDigit = digitsOfWord.first().digitToInt()
        val lastDigit = digitsOfWord.last().digitToInt()
        return firstDigit * 10 + lastDigit
    }

    fun solveChallenge(input: List<String>): Int =
        input.fold(0) { acc, word -> acc + getWordCalibrationValue(word) }
}

fun main() {
    val input = readInput("day01")
    solveChallenge(input).println()
}
