package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*

@DisplayName("Day 7")
class Day7Test {

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        val ips = """
        abba[mnop]qrst
        abcd[bddb]xyyx
        aaaa[qwer]tyui
        ioxxoj[asdfgh]zxcvbn""".trimIndent().lines()

        @Test
        fun `How many IPs in your puzzle input support TLS`() {
            assertThat(Day7(ips).partOne()).isEqualTo(2)
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