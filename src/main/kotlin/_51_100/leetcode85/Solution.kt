package _51_100.leetcode85

import java.util.*

fun maximalRectangle(matrix: Array<CharArray>): Int {
    if (matrix.isEmpty()) {
        return 0
    }

    if (matrix[0].isEmpty()) {
        return 0
    }

    val height = matrix.size
    val width = matrix[0].size

    val resultMatrix = Array<IntArray>(height) {
        IntArray(width)
    }

    for (i in 0 until width) {
        for (j in 0 until height) {
            if (matrix[j][i] == '1') {
                if (j == 0) {
                    resultMatrix[j][i] = 1
                } else {
                    resultMatrix[j][i] = resultMatrix[j-1][i] + 1
                }
            } else {
                resultMatrix[j][i] = 0
            }
        }
    }

    var maxArea = 0

    for (i in 0 until height) {
        maxArea = maxArea.coerceAtLeast(largestRectangleArea(resultMatrix[i]))
    }

    return maxArea
}

fun largestRectangleArea(heights: IntArray): Int {
    val stack = Stack<Int>()
    // init new heights array
    val nums = IntArray(heights.size + 2)
    nums[0] = 0
    for (i in 1 until nums.size - 1) {
        nums[i] = heights[i - 1]
    }
    nums[nums.size - 1] = 0

    stack.push(0)
    var maxArea = 0
    for (i in 1 until nums.size) {
        while (nums[i] < nums[stack.peek()]) {
            val topIndex = stack.pop()
            maxArea = maxArea.coerceAtLeast(nums[topIndex] * (i - stack.peek() - 1))
        }

        stack.push(i)
    }

    return maxArea
}

fun main() {
    val n1 = charArrayOf('1','0','1','0','0')
    val n2 = charArrayOf('1','0','1','1','1')
    val n3 = charArrayOf('1','1','1','1','1')
    val n4 = charArrayOf('1','0','0','1','0')

    val nums = arrayOf(n1, n2, n3, n4)
    println(maximalRectangle(nums))
}