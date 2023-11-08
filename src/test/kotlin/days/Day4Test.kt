package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*

@DisplayName("Day 4")
class Day4Test {

    val input = listOf(
            "aaaaa-bbb-z-y-x-123[abxyz]",
            "a-b-c-d-e-f-g-h-987[abcde]",
            "not-a-real-room-404[oarel]",
            "totally-real-room-200[decoy]"
    )

    @Nested
    @DisplayName("Part 1")
    inner class Part1 {
        @Test
        fun `How far is the shortest path to the destination`() {
            assertThat(Day4(input).partOne()).isEqualTo(1514)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `How far is the shortest path to the destination`() {
            assertThat(Day4(listOf("qzmt-zixmtkozy-ivhz-343[]")).partTwo()).isEqualTo(0)
        }    }
}