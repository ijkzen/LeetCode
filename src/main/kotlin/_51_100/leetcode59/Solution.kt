package _51_100.leetcode59

enum class Direction {
    UP,
    RIGHT,
    DOWN,
    LEFT
}

fun generateMatrix(n: Int): Array<IntArray> {
    val result = Array<IntArray>(n) {
        IntArray(n) { 0 }
    }

    var widthLeft = n
    var heightLeft = n - 1
    var x = 0
    var y = -1
    var currentDirection = Direction.RIGHT
    var index = 1
    while (widthLeft >= 1 || heightLeft >= 1) {
        when (currentDirection) {
            Direction.RIGHT -> {
                for (i in 1..widthLeft) {
                    result[x][y + i] = index++
                }
                y += widthLeft
                widthLeft--
                currentDirection = Direction.DOWN
            }
            Direction.DOWN -> {
                for (i in 1..heightLeft) {
                    result[x + i][y] = index++
                }
                x += heightLeft
                heightLeft--
                currentDirection = Direction.LEFT
            }
            Direction.LEFT -> {
                for (i in 1..widthLeft) {
                    result[x][y - i] = index++
                }
                y -= widthLeft
                widthLeft--
                currentDirection = Direction.UP
            }
            Direction.UP -> {
                for (i in 1..heightLeft) {
                    result[x - i][y] = index++
                }
                x -= heightLeft
                heightLeft--
                currentDirection = Direction.RIGHT
            }
        }
    }


    return result
}

fun main() {
    println(generateMatrix(3))
}