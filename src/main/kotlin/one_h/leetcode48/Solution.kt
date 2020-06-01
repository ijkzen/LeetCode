package one_h.leetcode48


fun rotate(matrix: Array<IntArray>): Unit {
    val width = matrix.size

    for (i in 0 until width / 2) {
        for (j in i until width - 1 - i) {
            swap(matrix, i, j, j, width - 1 - i)
            swap(matrix, i, j, width - 1 - i, width - 1 - j)
            swap(matrix, i, j, width - 1 - j, i)
        }
    }
}

fun swap(matrix: Array<IntArray>, x1: Int, y1: Int, x2: Int, y2: Int) {
    val tmp = matrix[x1][y1]
    matrix[x1][y1] = matrix[x2][y2]
    matrix[x2][y2] = tmp
}