package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*

@DisplayName("Day 7")
class Day7Test {

    val ips = """
        abba[mnop]qrst
        abcd[bddb]xyyx
        aaaa[qwer]tyui
        ioxxoj[asdfgh]zxcvbn""".trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `what is the error-corrected version of the message being sent`() {
            assertThat(Day7(ips).partOne()).isEqualTo(2)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Six of the listed triangles are possible`() {
            assertThat(Day6(ips).partTwo()).isEqualTo("advent")
        }
    }
}