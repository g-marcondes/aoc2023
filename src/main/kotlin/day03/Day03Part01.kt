package day03

import day03.Day03Part01.solveChallenge
import println
import readInput

object Day03Part01 {
    fun isSymbol(char: Char) =
        !char.isLetterOrDigit() && char != '.'

    fun isSymbolAdjacent(row: Int, column: Int, input: List<String>): Boolean {
        val size = input.size // assuming size x size input

        return if (row > 0 && isSymbol(input[row - 1][column])) true
        else if (row < size - 1 && isSymbol(input[row + 1][column])) true
        else if (column > 0 && isSymbol(input[row][column - 1])) true
        else if (column < size - 1 && isSymbol(input[row][column + 1])) true
        else if (row > 0 && column > 0 && isSymbol(input[row - 1][column - 1])) true
        else if (row > 0 && column < size - 1 && isSymbol(input[row - 1][column + 1])) true
        else if (row < size - 1 && column > 0 && isSymbol(input[row + 1][column - 1])) true
        else if (row < size - 1 && column < size - 1 && isSymbol(input[row + 1][column + 1])) true
        else false
    }


    fun solveChallenge(input: List<String>): Int {
        var isPart = false
        var part = ""

        return input.foldIndexed(0) { row, result, line ->
            val partsInLine = line.toCharArray().foldIndexed(0) { column, acc, char ->
                if (char.isDigit()){
                    part = "$part$char"
                    if (!isPart) isPart = isSymbolAdjacent(row, column, input)
                    acc
                }
                else {
                    val intPart = if (part.isNullOrEmpty()) 0 else part.toInt()
                    part = ""
                    if (isPart) {
                        isPart = false
                        acc + intPart
                    }
                    else {
                        isPart = false
                        acc
                    }
                }
            }
            result + partsInLine
        }
    }
}

fun main() {
    val input = readInput("day03")
    solveChallenge(input).println()
}
