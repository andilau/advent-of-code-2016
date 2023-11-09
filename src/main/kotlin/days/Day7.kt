package days

@AdventOfCodePuzzle(
        name = "Internet Protocol Version 7",
        url = "https://adventofcode.com/2016/day/7",
        date = Date(day = 7, year = 2016)
)
class Day7(private val input: List<String>) : Puzzle {


    override fun partOne(): Int = input.map { IP7.from(it) }
            .filter { it.supportsTLS() }.also { println(it) }.count()

    data class IP7(val parts: List<String>) {

        fun supportsTLS(): Boolean {
            val map: List<Boolean> = parts.map { seq -> hasAbba(seq) }.also { println(it) }
            return map.filterIndexed { index, _ -> index % 2 == 1 }.none { it } &&
                    map.filterIndexed { index, _ -> index % 2 == 0 }.any { it }

        }

        companion object {
            fun from(line: String): IP7 {
                val line1 = line
                val args = line1.split("[", "]")
                return IP7(args).also { println(it) }
            }

            fun hasAbba(string: String): Boolean {
                val abba = (0..string.lastIndex - 3).firstOrNull() {
                    string[it] != string[it + 1] &&
                            string[it] == string[it + 3] &&
                            string[it + 1] == string[it + 2]
                }
                return abba != null
            }
        }

    }

    override fun partTwo(): Int = 0
}
