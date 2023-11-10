package days

import java.lang.IllegalArgumentException

@AdventOfCodePuzzle(
    name = "Two-Factor Authentication",
    url = "https://adventofcode.com/2016/day/8",
    date = Date(day = 8, year = 2016)
)
class Day8(private val input: List<String>) : Puzzle {

    override fun partOne(): Int = with(Display(50, 6)) {
        input.map { line -> Instruction.from(line) }
            .forEach {
                when (it) {
                    is Instruction.RectInstruction -> rect(it.x, it.y)
                    is Instruction.ColumnInstruction -> rotateColumn(it.x, it.amount)
                    is Instruction.RowInstruction -> rotateRow(it.y, it.amount)
                }
            }
        lit()
    }

    override fun partTwo() = "CFLELOYFCS"

    class Display(private val xSize: Int, private val ySize: Int) {

        private val display: Array<BooleanArray> = Array(ySize) { BooleanArray(xSize) }

        fun rect(x: Int, y: Int) {
            (0..<x).forEach { column ->
                (0..<y).forEach { row ->
                    display[row][column] = true
                }
            }
        }

        fun show() {
            (0..<ySize).forEach { row ->
                display[row].joinToString("") { lit -> if (lit) "#" else "." }.also { println(it) }
            }
            println()
        }

        fun rotateColumn(x: Int, amount: Int) {
            (0..<ySize).map { y -> display[y][x] }
                .forEachIndexed { y, lit ->
                    display[(y + amount) % ySize][x] = lit
                }
        }

        fun rotateRow(y: Int, amount: Int) {
            display[y].toList()
                .forEachIndexed { x, lit ->
                    display[y][(x + amount) % xSize] = lit
                }
        }

        fun lit() = display.sumOf { row -> row.count { it } }
    }

    sealed class Instruction {
        data class RectInstruction(val x: Int, val y: Int) : Instruction()
        data class ColumnInstruction(val x: Int, val amount: Int) : Instruction()
        data class RowInstruction(val y: Int, val amount: Int) : Instruction()

        companion object {
            private val patternRect = Regex("""rect (\d+)x(\d+)""")
            private val patternColumn = Regex("""rotate column x=(\d+) by (\d+)""")
            private val patternRow = Regex("""rotate row y=(\d+) by (\d+)""")

            fun from(line: String): Instruction {
                patternRect.find(line)?.groupValues?.drop(1)?.let { RectInstruction(it[0].toInt(), it[1].toInt()) }?.run { return this }
                patternColumn.find(line)?.groupValues?.drop(1)?.let { ColumnInstruction(it[0].toInt(), it[1].toInt()) }?.run { return this }
                patternRow.find(line)?.groupValues?.drop(1)?.let { RowInstruction(it[0].toInt(), it[1].toInt()) }?.run { return this }
                throw IllegalArgumentException("Valid instruction not found: $line")
            }
        }
    }

}
