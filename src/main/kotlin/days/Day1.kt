package days

import days.Day1.Direction.*

@AdventOfCodePuzzle(
    name = "No Time for a Taxicab",
    url = "https://adventofcode.com/2016/day/1",
    date = Date(day = 1, year = 2016)
)
class Day1(input: String) : Puzzle {

    private val instructions = input
        .split(", ")
        .filter { s -> s.length >= 2 }
        .map(Instruction::from)

    override fun partOne(): Int = instructions
        .fold(State()) { state, instruction -> state.toNext(instruction) }
        .manhattanDistance()

    override fun partTwo() = instructions
        .scan(State()) { state, instruction -> state.toNext(instruction) }
        .groupBy { state -> Pair(state.x, state.y) }
        .filterValues { states -> states.size > 1 }
        .keys
        .minOfOrNull { state -> state.first + state.second }
        ?: IllegalArgumentException()

    data class Instruction(val turn: Char = '_', val steps: Int = 0) {
        companion object {
            fun from(text: String): Instruction =
                Instruction(text.first(), text.substring(1).toInt())
        }
    }

    data class State(
        val x: Int = 0,
        val y: Int = 0,
        val facing: Direction = NORTH
    ) {
        fun manhattanDistance() = Math.abs(x) + Math.abs(y)

        fun toNext(instruction: Instruction): State {
            return turn(instruction.turn).move(instruction.steps)
        }

        private fun turn(turn: Char): State = when (facing) {
            NORTH -> if (turn == 'R') copy(facing = EAST) else copy(facing = WEST)
            EAST -> if (turn == 'R') copy(facing = SOUTH) else copy(facing = NORTH)
            SOUTH -> if (turn == 'R') copy(facing = WEST) else copy(facing = EAST)
            WEST -> if (turn == 'R') copy(facing = NORTH) else copy(facing = SOUTH)
        }

        fun move(steps: Int): State = when (facing) {
            NORTH -> copy(y = y + steps)
            SOUTH -> copy(y = y - steps)
            EAST -> copy(x = x + steps)
            WEST -> copy(x = x - steps)
        }
    }

    enum class Direction {
        NORTH, EAST, SOUTH, WEST;
    }
}
