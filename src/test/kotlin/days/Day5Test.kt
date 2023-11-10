package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*

@DisplayName("Day 5")
class Day5Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `What is the password`() {
            assertThat(Day5("abc").partOne()).isEqualTo("18f47a30")
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `What is the password`() {
            assertThat(Day5("abc").partTwo()).isEqualTo("05ace8e3")
        }    }
}