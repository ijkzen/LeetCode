package _51_100.leetcode55

fun canJump(nums: IntArray): Boolean {
    var end = 0 // 当前前进的目标
    var maxPosition = 0 // 0到i区间内所有的数字能到达的最远的地方
    for (i in 0..(nums.size - 2)) {
        val newPosition = nums[i] + i
        maxPosition = maxPosition.coerceAtLeast(newPosition)
        if (nums[i] == 0 && maxPosition == newPosition) {
            break
        }

        if (i == end) {
            end = maxPosition
        }
    }

    return maxPosition >= nums.size - 1
}

fun main() {
    val nums = intArrayOf(3,2,1,1,4)
    println(canJump(nums))
}