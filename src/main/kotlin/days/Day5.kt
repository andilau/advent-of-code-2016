package days

import java.math.BigInteger
import java.security.MessageDigest

@AdventOfCodePuzzle(
        name = "How About a Nice Game of Chess?",
        url = "https://adventofcode.com/2016/day/5",
        date = Date(day = 5, year = 2016)
)
class Day5(val doorId: String) : Puzzle {
    override fun partOne(): String = generateSequence(0) { it + 1 }
            .map { (doorId + it).md5() }
            .filter { it.startsWith("00000") }
            .map { it[5] }
            .take(8).joinToString("")

    override fun partTwo(): String = generateSequence(0) { it + 1 }
            .map { (doorId + it).md5() }
            .filter { it.startsWith("00000") }
            .map { it[5] to it[6] }
            .filter { it.first.isDigit() }
            .map { it.first.digitToInt() to it.second }
            .filter { it.first < 8 }
            .runningFold("        ") { password, pair ->
                StringBuffer(password)
                        .apply { if (get(pair.first).isWhitespace()) setCharAt(pair.first, pair.second) }
                        .toString()
            }
            .first { it.none { it.isWhitespace() } }

    private fun String.md5(): String {
        val md = MessageDigest.getInstance("MD5")
        return BigInteger(1, md.digest(this.toByteArray())).toString(16).padStart(32, '0')
    }
}

