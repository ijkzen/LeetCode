package _51_100.leetcode74

data class Point(val x: Int, val y: Int)

fun getPoint(index: Int, width: Int): Point {
    return Point(index / width, index % width)
}

fun compare(start: Int, end: Int, matrix: Array<IntArray>, target: Int): Boolean {
    val width = matrix[0].size
    when {
        start < end -> {
            val startPoint = getPoint(start, width)
            val endPoint = getPoint(end, width)

            if (end - start == 1) {
                return matrix[startPoint.x][startPoint.y] == target || matrix[endPoint.x][endPoint.y] == target
            }

            val middle = (start + end) / 2
            val middlePoint = getPoint(middle, width)

            if (matrix[startPoint.x][startPoint.y] == target) {
                return true
            }

            if (matrix[endPoint.x][endPoint.y] == target) {
                return true
            }

            return when {
                matrix[middlePoint.x][middlePoint.y] > target -> {
                    compare(start, middle, matrix, target)
                }
                matrix[middlePoint.x][middlePoint.y] < target -> {
                    compare(middle, end, matrix, target)
                }
                else -> {
                    true
                }
            }

        }
        start == end -> {
            val point = getPoint(start, width)
            return matrix[point.x][point.y] == target
        }
        else -> {
            return false
        }
    }
}

fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
    if (matrix.isEmpty() || matrix[0].isEmpty()) {
        return false
    }

    val width = matrix[0].size
    val height = matrix.size

    if (target < matrix[0][0] || target > matrix[height - 1][width - 1]) {
        return false
    }

    return compare(0, width * height - 1, matrix, target)
}