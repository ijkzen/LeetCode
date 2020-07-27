package _50.leetcode45

fun jump1(nums: IntArray): Int {
    var end = 0
    var maxPosition = 0
    var steps = 0
    for (i in 0..(nums.size - 2)) {
        val newPosition = nums[i] + i
        maxPosition = maxPosition.coerceAtLeast(newPosition)
        if (i == end) {
            end = maxPosition
            steps++
        }
    }

    return steps
}

fun main() {
    val nums = intArrayOf(2, 3, 1, 1, 4, 2, 1)
    println(jump1(nums))
}