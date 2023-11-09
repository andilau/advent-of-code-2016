package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*

@DisplayName("Day 6")
class Day6Test {

    val messages = """
        eedadn
        drvtee
        eandsr
        raavrd
        atevrs
        tsrnev
        sdttsa
        rasrtv
        nssdts
        ntnada
        svetve
        tesnvt
        vntsnd
        vrdear
        dvrsen
        enarar""".trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `what is the error-corrected version of the message being sent`() {
            assertThat(Day6(messages).partOne()).isEqualTo("easter")
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {

        @Test
        fun `Six of the listed triangles are possible`() {
            assertThat(Day6(messages).partTwo()).isEqualTo("advent")
        }
    }
}