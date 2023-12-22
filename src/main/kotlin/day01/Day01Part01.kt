package day01

import println
import readInput

fun main() {

    fun getWordCalibrationValue(word: String): Int {
        val digitsOfWord = word.filter { it.isDigit() }
        val firstDigit = digitsOfWord.first().digitToInt()
        val lastDigit = digitsOfWord.last().digitToInt()
        return firstDigit * 10 + lastDigit
    }

    fun solveChallenge(input: List<String>): Int {

        val total = input.fold(0) { acc, word -> acc + getWordCalibrationValue(word) }

        return total
    }

    val input = readInput("day01")
    solveChallenge(input).println()
}
