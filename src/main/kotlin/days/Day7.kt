package days

@AdventOfCodePuzzle(
    name = "Internet Protocol Version 7",
    url = "https://adventofcode.com/2016/day/7",
    date = Date(day = 7, year = 2016)
)
class Day7(private val input: List<String>) : Puzzle {

    override fun partOne(): Int = input.map { IP7.from(it) }.count { it.supportsTLS() }

    override fun partTwo(): Int = input.map { IP7.from(it) }.count { it.supportsSSL() }

    data class IP7(val parts: List<String>) {

        fun supportsTLS(): Boolean {
            return parts.filterIndexed { index, _ -> index % 2 == 1 }.none { hasAbba(it) } &&
                    parts.filterIndexed { index, _ -> index % 2 == 0 }.any { hasAbba(it) }
        }

        fun supportsSSL(): Boolean {
            return true
        }

        companion object {

            fun from(line: String): IP7 {
                val line1 = line
                val args = line1.split("[", "]")
                return IP7(args)
            }

            fun hasAbba(string: String): Boolean {
                return (0..string.lastIndex - 3).firstOrNull() {
                    string[it] != string[it + 1] &&
                            string[it] == string[it + 3] &&
                            string[it + 1] == string[it + 2]
                } != null
            }
        }
    }
}
