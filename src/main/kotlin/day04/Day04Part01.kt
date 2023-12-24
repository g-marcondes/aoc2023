package day04

import day04.Day04Part01.solveChallenge
import println
import readInput
import kotlin.math.pow

object Day04Part01 {
    fun getPoints(winningSet: List<Int>, numbers: List<Int>): Int {
        val winningNumbersCount = numbers.count { winningSet.contains(it) }
        val base = 2.0
        return if (winningNumbersCount == 0) 0
        else base.pow(winningNumbersCount - 1).toInt()
    }

    fun solveChallenge(input: List<String>): Int =
        input.fold(0) { acc, line -> // Card X: 1 2 3 | 4 5 6
            val splits = line.split(":")
            val sets = splits[1].split("|")
            val winningSet = sets[0].split(" ").filter { it.isNotEmpty() }.map { it.trim().toInt() }
            val numbers = sets[1].split(" ").filter { it.isNotEmpty() }.map { it.trim().toInt() }
            acc + getPoints(winningSet, numbers)
        }
}

fun main() {
    val input = readInput("day04")
    solveChallenge(input).println()
}
