package _1_50.leetcode45

data class IntPackage(var count: Int = 0)

fun jump(nums: IntArray): Int {
    if (nums.size == 1) {
        return 0
    }

    val result = IntPackage(nums.size)
    singleJump(nums, 0, 0, result)
    return result.count
}

fun singleJump(nums: IntArray, currentIndex: Int, currentCount: Int, minCount: IntPackage) {
    val currentValue =
        if (nums[currentIndex] > (nums.size - 1 - currentIndex)) nums.size - 1 - currentIndex else nums[currentIndex]
    for (i in currentValue downTo 1) {
        if (currentIndex + i == nums.size - 1) {
            if (currentCount + 1 < minCount.count) {
                minCount.count = currentCount + 1
            }
        } else if (currentIndex + i > nums.size - 1) {
            continue
        } else {
            singleJump(nums, currentIndex + i, currentCount + 1, minCount)
        }
    }
}

fun main() {
    val nums = intArrayOf(5)
    println(jump(nums))
}