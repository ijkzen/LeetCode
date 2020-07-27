package _51_100.leetcode54

enum class Direction {
    UP,
    RIGHT,
    DOWN,
    LEFT
}

fun spiralOrder(matrix: Array<IntArray>): List<Int> {

    if (matrix.isEmpty()) {
        return ArrayList()
    }

    val result = ArrayList<Int>()
    val m = matrix[0].size
    val n = matrix.size

    var finalWidth = if (m > n) m - n + 1 else 1
    var finalHeight = if (n > m) n - m  else 1

    var widthLeft = matrix[0].size
    var heightLeft = matrix.size - 1
    var currentDirection = Direction.RIGHT
    var x = 0
    var y = -1

    if (m == 1) {
        currentDirection = Direction.DOWN
        x = -1
        y = 0
        widthLeft = 0
        heightLeft = matrix.size
        finalHeight = n
    }

    if (n == 1) {
        currentDirection = Direction.RIGHT
        x = 0
        y = -1
        widthLeft = matrix[0].size
        heightLeft = 0
        finalWidth = m

    }


    while (widthLeft >= finalWidth || heightLeft >= finalHeight) {
        when (currentDirection) {
            Direction.UP -> {
                for (i in 1..heightLeft) {
                    result.add(matrix[x - i][y])
                }
                x -= heightLeft
                heightLeft--
                currentDirection = Direction.RIGHT
            }
            Direction.RIGHT -> {
                for (i in 1..widthLeft) {
                    result.add(matrix[x][y + i])
                }
                y += widthLeft
                widthLeft--
                currentDirection = Direction.DOWN
            }
            Direction.DOWN -> {
                for (i in 1..heightLeft) {
                    result.add(matrix[x + i][y])
                }
                x += heightLeft
                heightLeft--
                currentDirection = Direction.LEFT
            }
            Direction.LEFT -> {
                for (i in 1..widthLeft) {
                    result.add(matrix[x][y - i])
                }
                y -= widthLeft
                widthLeft--
                currentDirection = Direction.UP
            }
        }
    }

    return result
}

fun main() {
    val list1 = intArrayOf(1)
    val list2 = intArrayOf(5)
    val list3 = intArrayOf(9)

    val matrix = Array<IntArray>(3) {
        when (it) {
            0 -> list1
            1 -> list2
            2 -> list3
            else -> list1
        }
    }

    println(spiralOrder(matrix))
}

