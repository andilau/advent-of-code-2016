package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*

@DisplayName("Day 1")
class Day1Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @TestFactory
        @DisplayName("Test")
        fun shouldArriveAtFloor() = listOf(
            "R2, L3" to 5,
            "R2, R2, R2" to 2,
            "R5, L5, R5, R3" to 12,
        ).map { (instructions, distance) ->
            DynamicTest.dynamicTest("""Example $instructions should arrive at floor $distance" """) {
                assertThat(Day1(instructions).partOne()).isEqualTo(distance)
            }
        }
    }

    // R8, R4, R4, R8
    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @TestFactory
        @DisplayName("Test")
        fun shouldArriveAtFloor() = listOf("R8, R4, R4, R8" to 4).map { (instructions, distance) ->
            DynamicTest.dynamicTest("""Example $instructions should arrive at floor $distance" """) {
                assertThat(Day1(instructions).partTwo()).isEqualTo(distance)
            }
        }
    }
}