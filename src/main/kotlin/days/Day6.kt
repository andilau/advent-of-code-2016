package days

@AdventOfCodePuzzle(
        name = "Signals and Noise",
        url = "https://adventofcode.com/2016/day/6",
        date = Date(day = 6, year = 2016)
)
class Day6(private val input: List<String>) : Puzzle {

    private val indices = input.first().indices

    override fun partOne(): String =
            indices.map { index ->
                input.map { it[index] }
                        .groupingBy { it }.eachCount()
                        .maxBy { it.value }.key
            }.joinToString("")

    override fun partTwo(): String =
            indices.map { index ->
                input.map { it[index] }
                        .groupingBy { it }.eachCount()
                        .minBy { it.value }.key
            }.joinToString("")
}
