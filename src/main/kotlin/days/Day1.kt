package days

import days.Day1.Direction.*
import kotlin.math.abs

@AdventOfCodePuzzle(
    name = "No Time for a Taxicab",
    url = "https://adventofcode.com/2016/day/1",
    date = Date(day = 1, year = 2016)
)
class Day1(input: String) : Puzzle {

    private val instructions = input
        .split(", ")
        //.filter { s -> s.length >= 2 }
        .map(Instruction::from)

    override fun partOne(): Int = instructions.walk().last().manhattanDistance

    override fun partTwo(): Int {
        val visited = mutableSetOf<Point>()

        for (point in instructions.walk()) {
            if (point in visited)
                return point.manhattanDistance
            visited += point
        }
        error("Invalid Input")
    }

    private fun List<Instruction>.walk() = sequence<Point> {
        var pos = Point.ORIGIN
        var dir = NORTH
        this@walk.forEach() { instruction ->
            dir = dir.turn(instruction.turn)
            (1..instruction.steps).forEach { _ ->
                pos = pos.move(dir)
                yield(pos)
            }
        }
    }

    data class Point(val x: Int, val y: Int) {
        fun move(facing: Direction): Point = when (facing) {
            NORTH -> copy(y = y + 1)
            SOUTH -> copy(y = y - 1)
            EAST -> copy(x = x + 1)
            WEST -> copy(x = x - 1)
        }

        val manhattanDistance get() = abs(x) + abs(y)

        companion object {
            val ORIGIN: Point = Point(0, 0)
        }
    }

    data class Instruction(val turn: Char, val steps: Int) {
        companion object {
            fun from(text: String): Instruction =
                Instruction(text.first(), text.substring(1).toInt())
        }
    }

    enum class Direction {
        NORTH, EAST, SOUTH, WEST;

        fun turn(turn: Char): Direction = when (this) {
            NORTH -> if (turn == 'R') EAST else WEST
            EAST -> if (turn == 'R') SOUTH else NORTH
            SOUTH -> if (turn == 'R') WEST else EAST
            WEST -> if (turn == 'R') NORTH else SOUTH
        }
    }
}
