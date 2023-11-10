import days.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import util.InputReader

@DisplayName("Solutions")
class SolutionsTest {

    @TestFactory
    fun testAdventOfCode() = listOf(
        Day1(InputReader.getInputAsString(1)) to Pair(288, 111),
        Day2(InputReader.getInputAsList(2)) to Pair("53255", "7423A"),
        Day3(InputReader.getInputAsList(3)) to Pair(869, 1544),
        Day4(InputReader.getInputAsList(4)) to Pair(185371, 984),
        Day5(InputReader.getInputAsString(5)) to Pair("4543c154", "1050cbbd"),
        Day6(InputReader.getInputAsList(6)) to Pair("wkbvmikb", "evakwaga"),
    )
        .map { (day, answers) ->
            DynamicTest.dynamicTest("${day.javaClass.simpleName} -> ${answers.first} / ${answers.second}") {
                assertThat(day.partOne()).isEqualTo(answers.first)
                assertThat(day.partTwo()).isEqualTo(answers.second)
            }
        }
}