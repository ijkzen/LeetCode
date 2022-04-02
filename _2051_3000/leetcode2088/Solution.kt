package _2051_3000.leetcode2088

/**
 * Your runtime beats 100 % of kotlin submissions
 * Your memory usage beats 60 % of kotlin submissions (55.9 MB)
 */
fun countPyramids(grid: Array<IntArray>): Int {
    val row = grid.size
    if (row < 2) {
        return 0
    }
    val col = grid[0].size
    if (col < 3) {
        return 0
    }

    val f = Array<IntArray>(row) {IntArray(col)}
    var result = 0
    for (i in row - 1 downTo 0) {
        for (j in 0 until col) {
            if (grid[i][j] == 0) {
                f[i][j] = -1
            } else if (i == row - 1 || j == 0 || j == col - 1){
                f[i][j] = 0
            } else {
                f[i][j] = Math.min(Math.min(f[i+1][j-1], f[i+1][j]), f[i+1][j+1]) + 1
                result += f[i][j]
            }
        }
    }

    for (i in 0 until row) {
        for (j in 0 until col) {
            if (grid[i][j] == 0) {
                f[i][j] = -1
            } else if (i == 0 || j == 0 || j == col - 1) {
                f[i][j] = 0
            } else {
                f[i][j] = Math.min(Math.min(f[i-1][j-1], f[i-1][j]), f[i-1][j+1]) + 1
                result += f[i][j]
            }
        }
    }

    return result
}

fun main() {
    val grid = Array<IntArray>(2) {
        IntArray(3)
    }
    grid[0] = listOf(1, 1, 1).toIntArray()
    grid[1] = listOf(1, 1, 1).toIntArray()

    println(countPyramids(grid))
}