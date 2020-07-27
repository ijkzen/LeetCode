package _51_100.leetcode63

fun uniquePathsWithObstacles(obstacleGrid: Array<IntArray>): Int {

    val width = obstacleGrid[0].size
    val height = obstacleGrid.size

    val resultMatrix = Array<IntArray>(height) {
        IntArray(width)
    }

    for (i in 0 until height) {
        for (j in 0 until width) {
            if (obstacleGrid[i][j] == 1) {
                resultMatrix[i][j] = 0
            } else {
                when {
                    i == 0 -> {
                        resultMatrix[i][j] = if (j == 0) 1 else resultMatrix[i][j - 1]
                    }
                    j == 0 -> {
                        resultMatrix[i][j] = if (i == 0) 1 else resultMatrix[i - 1][j]
                    }
                    else -> {
                        resultMatrix[i][j] = resultMatrix[i - 1][j] + resultMatrix[i][j - 1]
                    }
                }
            }
        }
    }

    return resultMatrix[height - 1][width - 1]
}

fun main() {
    val obstacleGrid = Array<IntArray>(1) {
        when (it) {
            0 -> {
                intArrayOf(0, 1, 0)
            }
            1 -> {
                intArrayOf(0, 1, 0)
            }
            2 -> {
                intArrayOf(0, 0, 0)
            }
            else -> {
                intArrayOf(0, 0, 0)
            }
        }
    }

    println(uniquePathsWithObstacles(obstacleGrid))
}