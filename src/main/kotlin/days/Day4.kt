package days

import java.lang.IllegalArgumentException

@AdventOfCodePuzzle(
        name = "Security Through Obscurity",
        url = "https://adventofcode.com/2016/day/4",
        date = Date(day = 4, year = 2016)
)
class Day4(val input: List<String>) : Puzzle {
    override fun partOne(): Int =
            input.map { Room.of(it) }
                    .filter { it.isReal() }
                    .sumOf { it.sectorId }

    override fun partTwo(): Int =
            input.map { Room.of(it) }
                    .filter { it.isReal() }
                    .firstOrNull { it.decrypt() == "northpole object storage" }?.sectorId ?: throw IllegalArgumentException()

    data class Room(val nameEncrypted: List<String>, val sectorId: Int, val checksum: String) {

        fun decrypt(): String {
            return nameEncrypted.joinToString("-")
                    .let { ShiftCipher(sectorId).encode(it) }
        }

        fun isReal(): Boolean {
            return checksum() == checksum
        }

        private fun checksum(): String {
            val letterByCount: Map<Char, Int> = nameEncrypted.flatMap { it.asIterable() }.groupingBy { it }.eachCount()
            val letterCountSorted: List<Pair<Char, Int>> = letterByCount.toList()
                    .sortedWith(Comparator.comparing<Pair<Char, Int>?, Int?> { it.second }.reversed().thenComparing(Comparator.comparing { it.first }))
            return letterCountSorted.map { it.first }.take(5).joinToString("")
        }

        companion object {
            fun of(line: String): Room {
                val nameAndId = line.substringBefore('[').split('-')
                val checksum = line.substringAfter('[').substringBefore(']')
                return Room(nameAndId.dropLast(1), nameAndId.last().toInt(), checksum)
            }
        }

    }

    class ShiftCipher(private val base: Int = 1) {
        fun encode(text: String): String = text.map {
            when (it) {
                in 'a'..'z' -> 'a' + (it - 'a' + base) % 26
                '-' -> ' '
                else -> it
            }
        }.joinToString("")
    }
}

