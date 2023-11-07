package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*

@DisplayName("Day 2")
class Day2Test {

    val movementInstructions = """
        ULL
        RRDDD
        LURDL
        UUUUD""".lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `The bathroom code should be 1985`() {
            assertThat(Day2(movementInstructions).partOne()).isEqualTo("1985")
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `The bathroom code on the alternative keypad should be 5DB3`() {
            assertThat(Day2(movementInstructions).partTwo()).isEqualTo("5DB3")
        }
    }
}