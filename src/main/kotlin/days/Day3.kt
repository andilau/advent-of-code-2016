package days

@AdventOfCodePuzzle(
        name = "Squares With Three Sides",
        url = "https://adventofcode.com/2016/day/3",
        date = Date(day = 3, year = 2016)
)
class Day3(input: List<String>) : Puzzle {

    private val triangles: List<Triangle> = input.mapNotNull { Triangle.from(it) }
    override fun partOne(): Int = triangles.count { it.possible }

    override fun partTwo(): Int = triangles
            .windowed(3,3,false)
            .flatMap { threeTriangles -> listOf(
                    Triangle(listOf(threeTriangles[0].sides[0], threeTriangles[1].sides[0], threeTriangles[2].sides[0])),
                    Triangle(listOf(threeTriangles[0].sides[1], threeTriangles[1].sides[1], threeTriangles[2].sides[1])),
                    Triangle(listOf(threeTriangles[0].sides[2], threeTriangles[1].sides[2], threeTriangles[2].sides[2])),
            ) }
            .count { it.possible }

    data class Triangle(val sides: List<Int>) {
        val possible: Boolean
            get() {
                return sides.sorted().let { it[0] + it[1] > it[2] }
            }

        companion object {
            fun from(layout: String): Triangle? {
                return layout.split(' ')
                        .filter { it.isNotBlank() }
                        .map { it.toInt() }
                        .let { if (it.size == 3) Triangle(it) else null }
            }
        }
    }
}

