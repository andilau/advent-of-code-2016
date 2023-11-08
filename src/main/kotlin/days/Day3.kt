package days

import days.Day2.Point.Companion.DOWN
import days.Day2.Point.Companion.LEFT
import days.Day2.Point.Companion.RIGHT
import days.Day2.Point.Companion.UP
import java.lang.IllegalArgumentException

@AdventOfCodePuzzle(
        name = "Squares With Three Sides",
        url = "https://adventofcode.com/2016/day/3",
        date = Date(day = 3, year = 2016)
)
class Day3(private val triagles: List<String>) : Puzzle {

    override fun partOne(): Int = triagles.mapNotNull { Triangle.of(it) }.count { it.possible() }

    override fun partTwo(): Int = 0

    data class Triangle(val sides: List<Int>) {
        fun possible(): Boolean {
            return sides.sorted().also{print(it)}.let { it[0] + it[1] > it[2] }.also { println(it) }
        }

        companion object {
            fun of(layout: String): Triangle? {
                return layout.split(' ')
                        .filter { it.isNotBlank()}
                        .map { it.toInt() }
                        .let { if (it.size == 3) Triangle(it) else null }
            }
        }
    }
}

