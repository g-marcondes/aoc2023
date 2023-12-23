package challenges.adventofcode2023.day02

class RGBGame(val id: Int, private val sets: List<RGBSet>) {

    fun isValid(bag: RGBBag): Boolean {
        return sets.fold(true) { acc, set ->
            acc && set.red <= bag.red && set.blue <= bag.blue && set.green <= bag.green
        }
    }

    fun getPower(): Int {
        val minimumRed = sets.maxOfOrNull { it.red } ?: 1
        val minimumGreen = sets.maxOfOrNull { it.green } ?: 1
        val minimumBlue = sets.maxOfOrNull { it.blue } ?: 1

        return minimumRed * minimumGreen * minimumBlue
    }

    override fun toString(): String {
        val setsToString = sets.map { it.toString() }
        return "Game $id $setsToString"
    }
}