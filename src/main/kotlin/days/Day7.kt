package days

@AdventOfCodePuzzle(
    name = "Internet Protocol Version 7",
    url = "https://adventofcode.com/2016/day/7",
    date = Date(day = 7, year = 2016)
)
class Day7(private val input: List<String>) : Puzzle {

    override fun partOne(): Int = input.count { address -> IP7.from(address).supportsTLS() }

    override fun partTwo(): Int = input.count { address -> IP7.from(address).supportsSSL() }

    data class IP7(val parts: List<String>) {
        private val supernetSequences = parts.filterIndexed { index, _ -> index % 2 == 0 }
        private val hypernetSequences = parts.filterIndexed { index, _ -> index % 2 == 1 }

        fun supportsTLS(): Boolean {
            return hypernetSequences.none { hasAbba(it) } &&
                    supernetSequences.any { hasAbba(it) }
        }

        fun supportsSSL(): Boolean {
            val abaSequences = getAbaSequences(supernetSequences)
            return abaSequences.map { String(charArrayOf(it[1], it[0], it[1])) }.any { bab -> hypernetSequences.any { it.contains(bab) } }
        }

        companion object {

            fun from(line: String): IP7 {
                return IP7(line.split("[", "]"))
            }

            private fun hasAbba(string: String): Boolean {
                return (0..string.lastIndex - 3).firstOrNull() {
                    string[it] != string[it + 1] &&
                            string[it] == string[it + 3] &&
                            string[it + 1] == string[it + 2]
                } != null
            }

            private fun getAbaSequences(supernetSequences: List<String>): List<String> =
                supernetSequences.flatMap { seq -> seq.windowed(3, 1).filter { hasAba(it) } }

            private fun hasAba(sequence: String): Boolean = sequence[0] == sequence[2] && sequence[0] != sequence[1]
        }
    }
}
