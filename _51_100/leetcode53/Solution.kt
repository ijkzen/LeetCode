package _51_100.leetcode53

fun maxSubArray(nums: IntArray): Int {

    return max(nums, 0, nums.size - 1)
}

fun max(nums: IntArray, start: Int, end: Int): Int {
    if (start == end) {
        return nums[start]
    }

    val middle = (start + end) / 2
    val leftMax = max(nums, start, middle)
    val rightMax = max(nums, middle + 1, end)
    val middleMax = middleMax(nums, start, middle, end)

    return leftMax.coerceAtLeast(rightMax.coerceAtLeast(middleMax))
}

fun middleMax(nums: IntArray, start: Int, middle: Int, end: Int): Int {
    var value = nums[middle]
    var max = value

    var index = middle + 1
    while (index <= end) {
        value += nums[index]
        index++

        if (value > max) {
            max = value
        }
    }

    index = middle - 1
    value = max
    while (index >= start) {

        value += nums[index]
        index--

        if (value > max) {
            max = value
        }
    }

    return max
}

fun main() {
    val nums = intArrayOf(-2,1,-3,4,-1,2,1,-5,4)
    println(maxSubArray(nums))
}