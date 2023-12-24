package day04

import day04.Day04Part02.solveChallenge
import println
import readInput

object Day04Part02 {
    fun getWinningNumbersCount(winningSet: List<Int>, numbers: List<Int>) = numbers.count { winningSet.contains(it) }

    fun solveChallenge(input: List<String>): Int {
        var mapOfCards = mutableMapOf<Int, Int>()

        input.forEach { line -> // Card X: 1 2 3 | 4 5 6
            val splits = line.split(":")
            val cardNumber = splits[0].replace("Card", "").trim().toInt()
            val sets = splits[1].split("|")
            val winningSet = sets[0].split(" ").filter { it.isNotEmpty() }.map { it.trim().toInt() }
            val numbers = sets[1].split(" ").filter { it.isNotEmpty() }.map { it.trim().toInt() }
            val winningCount = getWinningNumbersCount(winningSet, numbers)
            mapOfCards[cardNumber] = mapOfCards[cardNumber]?.let { it + 1 } ?: 1 // original card
            for (i in 1 .. winningCount) {
                val cardNumberToIncrease = cardNumber + i
                mapOfCards[cardNumberToIncrease] = mapOfCards[cardNumberToIncrease]?.let {
                    it + mapOfCards[cardNumber]!!
                } ?: mapOfCards[cardNumber]!!
            }
        }

        return mapOfCards.keys.fold(0) { acc, cardNumber -> acc + mapOfCards[cardNumber]!! }
    }
}

fun main() {
    val input = readInput("day04")
    solveChallenge(input).println()
}
