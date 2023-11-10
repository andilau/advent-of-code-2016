package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*

@DisplayName("Day 8")
class Day8Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        val operations = """
        rect 3x2
        rotate column x=1 by 1
        rotate row y=0 by 4
        rotate column x=1 by 1""".trimIndent().lines()

        @Test
        fun `how many pixels should be lit`() {
            assertThat(Day8(operations).partOne()).isEqualTo(6)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        val ips = """
        aba[bab]xyz
        xyx[xyx]xyx
        aaa[kek]eke
        zazbz[bzb]cdb""".trimIndent().lines()

        @Test
        fun `How many IPs in your puzzle input support SSL`() {
            assertThat(Day7(ips).partTwo()).isEqualTo(3)
        }
    }
}