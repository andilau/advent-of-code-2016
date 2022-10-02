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
            "" to 0,
            "R2, L3" to 5,
            "R2, R2, R2" to 2,
            "R5, L5, R5, R3" to 12,
        ).map { (instructions, distance) ->
            DynamicTest.dynamicTest("""Example $instructions should arrive at floor $distance" """) {
                assertThat(Day1(instructions).partOne()).isEqualTo(distance)
            }
        }
    }
}