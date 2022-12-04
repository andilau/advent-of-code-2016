package days

import days.Day2.Point.Companion.ORIGIN

@AdventOfCodePuzzle(
    name = "Bathroom Security",
    url = "https://adventofcode.com/2016/day/2",
    date = Date(day = 2, year = 2016)
)
class Day2(val input: List<String>) : Puzzle {

    override fun partOne(): Int = input.fold(Pair(0, ORIGIN)) { (code, pos), line ->
        val npos = line.fold(pos) { p, c -> p.move(c) }
        Pair(code * 10 + npos.padKey().digitToInt(), npos)
    }.first


    override fun partTwo(): Int = 0

    private fun Point.padKey(): Char = when (this) {
        Point(-1, -1) -> '1'
        Point(0, -1) -> '2'
        Point(1, -1) -> '3'
        Point(-1, 0) -> '4'
        Point(0, 0) -> '5'
        Point(1, 0) -> '6'
        Point(-1, 1) -> '7'
        Point(0, 1) -> '8'
        Point(1, 1) -> '9'
        else -> error("Not on keypad: $this")
    }

    data class Point(val x: Int, val y: Int) {
        fun move(dir: Char): Point = when (dir) {
            'L' -> if (x >= 0) copy(x = x - 1) else this
            'R' -> if (x <= 0) copy(x = x + 1) else this
            'U' -> if (y >= 0) copy(y = y - 1) else this
            'D' -> if (y <= 0) copy(y = y + 1) else this
            else -> error("Check input, unknown direction: $dir")
        }

        companion object {
            val ORIGIN = Point(0, 0)
        }
    }
}

