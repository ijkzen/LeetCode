package _51_100.leetcode64

fun minPathSum(grid: Array<IntArray>): Int {

    val width = grid[0].size
    val height = grid.size

    val resultMatrix = Array<IntArray>(height) {
        IntArray(width)
    }

    for (i in 0 until height) {
        for (j in 0 until width) {
            when {
                i == 0 -> {
                    resultMatrix[i][j] = if (j == 0) grid[i][j] else resultMatrix[i][j - 1] + grid[i][j]
                }
                j == 0 -> {
                    resultMatrix[i][j] = if (i == 0) grid[i][j] else resultMatrix[i - 1][j] + grid[i][j]
                }
                else -> {
                    resultMatrix[i][j] = grid[i][j] + resultMatrix[i - 1][j].coerceAtMost(resultMatrix[i][j - 1])
                }
            }
        }
    }

    return resultMatrix[height - 1][width - 1]
}

fun main() {
    val grid = Array<IntArray>(3) {
        when (it) {
            0 -> {
                intArrayOf(1, 3, 1)
            }
            1 -> {
                intArrayOf(1, 5, 1)
            }
            2 -> {
                intArrayOf(4, 2, 1)
            }
            else -> {
                intArrayOf(0, 0, 0)
            }
        }
    }

    println(minPathSum(grid))
}