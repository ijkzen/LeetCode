package _51_100.leetcode73

fun setZeroes(matrix: Array<IntArray>): Unit {

    if (matrix.isEmpty()) {
        return
    }

    val rows = HashSet<Int>()
    val cols = HashSet<Int>()

    for (i in matrix.indices) {
        for (j in matrix[0].indices) {
            if (matrix[i][j] == 0) {
                rows.add(i)
                cols.add(j)
            }
        }
    }

    for (i in rows) {
        for (j in matrix[0].indices) {
            matrix[i][j] = 0
        }
    }

    for (i in cols) {
        for (j in matrix.indices) {
            matrix[j][i] = 0
        }
    }

}