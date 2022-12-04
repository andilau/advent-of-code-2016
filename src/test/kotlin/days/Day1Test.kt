package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*

@DisplayName("Day 1")
class Day1Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @TestFactory
        fun `How far is the shortest path to the destination`() = listOf(
            "R2, L3" to 5,
            "R2, R2, R2" to 2,
            "R5, L5, R5, R3" to 12,
        ).map { (instructions, distance) ->
            DynamicTest.dynamicTest("""Example $instructions shortest path ist '$distance' away" """) {
                assertThat(Day1(instructions).partOne()).isEqualTo(distance)
            }
        }
    }

    // R8, R4, R4, R8
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