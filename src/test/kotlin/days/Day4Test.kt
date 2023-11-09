package days

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.*
import java.lang.IllegalArgumentException

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
        fun `What is the sum of the sector IDs of the real rooms`() {
            assertThat(Day4(input).partOne()).isEqualTo(1514)
        }
    }

    @Nested
    @DisplayName("Part 2")
    inner class Part2 {
        @Test
        fun `What is the sector ID of the room where North Pole objects are stored`() {
            assertThrows<IllegalArgumentException> { Day4(listOf("qzmt-zixmtkozy-ivhz-343[]")).partTwo() }
        }
    }
}