package challenges.adventofcode2023.day02

class RGBSet(
    val red: Int,
    val green: Int,
    val blue: Int
) {
    override fun toString(): String {
        return "{red $red, green $green, blue $blue}"
    }
}