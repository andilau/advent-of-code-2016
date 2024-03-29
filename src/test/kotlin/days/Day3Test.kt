package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*

@DisplayName("Day 3")
class Day3Test {

    val triangles = """
        5 10 25
        5 10 15
        5 10 14""".trimIndent().lines()

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {

        @Test
        fun `One of the listed triangles is possible`() {
            assertThat(Day3(triangles).partOne()).isEqualTo(1)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        val triangles2 = """
        101 301 501
        102 302 502
        103 303 503
        201 401 601
        202 402 602
        203 403 603""".trimIndent().lines()

        @Test
        fun `Six of the listed triangles are possible`() {
            assertThat(Day3(triangles2).partTwo()).isEqualTo(6)
        }
    }
}