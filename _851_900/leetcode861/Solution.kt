package _851_900.leetcode861

fun getScore(matrix: Array<IntArray>): Int {
    if (matrix.isEmpty()) {
        return 0
    }

    val rowLength = matrix.size
    val colLength = matrix[0].size

    for (i in 0 until rowLength) {
        for (j in 0 until colLength) {

            val numberCol = getNumberForCol(matrix, j)
            if (numberCol < rowLength - numberCol) {
                reverseCol(matrix, j)
            }

            if (matrix[i][0] == 0) {
                reverseRow(matrix, i)
            }
        }
    }

    return parseMatrix2Score(matrix)
}

fun parseMatrix2Score(matrix: Array<IntArray>): Int {
    var value = 0
    for (i in matrix.indices) {
        value += parseIntArray2Score(matrix[i])
    }

    return value
}

fun parseIntArray2Score(array: IntArray): Int{
    var value = 0
    val length = array.size
    for (i in 0 until length) {
        value += (array[i] * Math.pow(2.toDouble(), (length - 1 - i).toDouble())).toInt()
    }

    return value
}

/**
 * 获取指定行内数字1的个数
 */
fun getNumberForRow(matrix: Array<IntArray>, row: Int): Int {
    val rowArray = matrix[row]
    var count = 0
    for (value in rowArray) {
        if (value == 1) {
            count++
        }
    }

    return count
}

/**
 * 获取指定列内数字1的个数
 */
fun getNumberForCol(matrix: Array<IntArray>, col: Int): Int {
    var count = 0
    for (i in matrix.indices) {
        if (matrix[i][col] == 1) {
            count++
        }
    }

    return count
}

/**
 * 反转指定行
 */
fun reverseRow(matrix: Array<IntArray>, row: Int) {
    val rowArray = matrix[row]

    for (i in rowArray.indices) {
        if (rowArray[i] == 0) {
            rowArray[i] = 1
        } else {
            rowArray[i] = 0
        }
    }
}

/**
 * 反转指定列
 */
fun reverseCol(matrix: Array<IntArray>, col: Int) {
    for (i in matrix.indices) {
        if (matrix[i][col] == 0) {
            matrix[i][col] = 1
        } else {
            matrix[i][col] = 0
        }
    }
}

fun main() {
    val matrix = Array<IntArray>(3) {
        when (it) {
            0 -> intArrayOf( 0, 1, 1)
            1 -> intArrayOf(1, 1, 1)
            2 -> intArrayOf(1, 0, 0)
            else -> intArrayOf()
        }
    }

    println(getScore(matrix))
}

