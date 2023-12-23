package day02

import challenges.adventofcode2023.day02.Colors
import challenges.adventofcode2023.day02.RGBBag
import challenges.adventofcode2023.day02.RGBGame
import challenges.adventofcode2023.day02.RGBSet
import day02.Day02Part02.solveChallenge
import println
import readInput

object Day02Part02 {
    fun getColorFromLine(color: String, line: String): Int { // 1 red, 2 blue, 3 green
        return line.split(",").fold(0) { acc, colorSplit ->
            if (colorSplit.contains(color, true)) colorSplit.split(color.lowercase())[0].trim().toInt()
            else acc
        }
    }

    private fun getGameFromLine(gameLine: String): RGBGame { // Game X : 1 red, 2 blue; 3 green, 4 blue
        val splits = gameLine.split(":")
        val gameNumber = splits[0].removePrefix("Game").trim().toInt()
        val sets = splits[1].split(";").fold(emptyList<RGBSet>()) { acc, line ->
            val red = getColorFromLine(Colors.RED.name, line)
            val green = getColorFromLine(Colors.GREEN.name, line)
            val blue = getColorFromLine(Colors.BLUE.name, line)
            acc + RGBSet(red, green, blue)
        }
        return RGBGame(gameNumber, sets)
    }


    fun solveChallenge(input: List<String>): Int {
        return input.fold(0) { acc, line ->
            val game = getGameFromLine(line)
            acc + game.getPower()
        }
    }
}

fun main() {
    val input = readInput("day02")
    solveChallenge(input).println()
}
