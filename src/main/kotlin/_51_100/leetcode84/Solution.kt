package _51_100.leetcode84

import java.util.*

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
    val nums = intArrayOf(2,1,5,6,2,3)
    println(largestRectangleArea(nums))
}