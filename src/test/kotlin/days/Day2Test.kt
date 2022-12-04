package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*

@DisplayName("Day 2")
class Day2Test {

    val instructions = """ULL
RRDDD
LURDL
UUUUD""".lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `How far is the shortest path to the destination`() {
            assertThat( Day2(instructions).partOne()).isEqualTo(1985)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @TestFactory
        fun `How many blocks away is the first location you visit twice`() = listOf("R8, R4, R4, R8" to 4).map { (instructions, distance) ->
            DynamicTest.dynamicTest("""Example $instructions first location you visit twice is '$distance' away""") {
                assertThat(Day1(instructions).partTwo()).isEqualTo(distance)
            }
        }
    }
}