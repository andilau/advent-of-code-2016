package days

import days.Day2.Point.Companion.DOWN
import days.Day2.Point.Companion.LEFT
import days.Day2.Point.Companion.RIGHT
import days.Day2.Point.Companion.UP
import java.lang.IllegalArgumentException

@AdventOfCodePuzzle(
    name = "Bathroom Security",
    url = "https://adventofcode.com/2016/day/2",
    date = Date(day = 2, year = 2016)
)
class Day2(private val input: List<String>) : Puzzle {

    private val keypadOne = """
        123
        456
        789""".trimIndent().lines().let { Keypad.of(it) }

    private val keypadTwo = """
        |  1
        | 234
        |56789
        | ABC
        |  D""".trimMargin().lines().let { Keypad.of(it) }

    override fun partOne(): String = solve(keypadOne)

    override fun partTwo(): String = solve(keypadTwo)

    private fun solve(keypad: Keypad): String {
        val start = keypad.find('5')

        return input.fold("" to start) { (code, key), line ->
            line.fold(key) { position, instruction ->
                when (instruction) {
                    'L' -> keypad.left(position)
                    'R' -> keypad.right(position)
                    'U' -> keypad.up(position)
                    'D' -> keypad.down(position)
                    else -> throw IllegalArgumentException("Unknown instruction: $instruction")
                }
            }.let { Pair(code + it.c, it) }
        }.first
    }

    data class Key(val c: Char, val pos: Point)

    data class Point(val x: Int, val y: Int) {
        companion object {
            val LEFT = Point(-1, 0)
            val RIGHT = Point(1, 0)
            val UP = Point(0, -1)
            val DOWN = Point(0, 1)
        }
    }

    data class Keypad(val keys: List<Key>) {
        private val byCharacter = keys.associateBy { it.c }
        private val byPosition = keys.associateBy { it.pos }

        fun left(key: Key): Key = find(key, LEFT)
        fun right(key: Key): Key = find(key, RIGHT)
        fun up(key: Key): Key = find(key, UP)
        fun down(key: Key): Key = find(key, DOWN)

        private fun find(key: Key, delta: Point): Key {
            val next = Point(key.pos.x + delta.x, key.pos.y + delta.y)
            return byPosition[next] ?: key
        }

        fun find(char: Char): Key = byCharacter[char] ?: throw IllegalArgumentException("Char $char not found in layout")

        companion object {
            fun of(layout: List<String>): Keypad {
                val keys: List<Key> = layout.flatMapIndexed { y, line ->
                    line.mapIndexedNotNull { x, char -> if (char.isWhitespace()) null else Key(char, Point(x, y)) }
                }.toList()
                return Keypad(keys)
            }
        }
    }
}

