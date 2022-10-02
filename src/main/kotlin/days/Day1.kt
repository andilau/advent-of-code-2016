package days

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

    override fun partOne(): Int {
        return instructions.fold(0) { acc, i -> acc + i.steps }
    }

    override fun partTwo() = 0

    class Instruction(val turn: Char = '_', val steps: Int = 0) {
        companion object {
            fun from(text: String): Instruction =
                Instruction(text.first(), text.drop(1).first().digitToInt())
        }
    }
}
