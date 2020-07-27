package _51_100.leetcode75

fun sortColors(nums: IntArray): Unit {
    var a = 0
    var b = 0
    var c = 0

    nums.forEach {
        when (it) {
            0 -> {
                a++
            }
            1 -> {
                b++
            }
            2 -> {
                c++
            }
            else -> {
            }
        }
    }

    for (i in nums.indices) {
        when {
            i < a -> {
                nums[i] = 0
            }
            i < a + b -> {
                nums[i] = 1
            }
            else -> {
                nums[i] = 2
            }
        }
    }
}

fun main() {
    val nums = intArrayOf(0, 1, 0, 1, 1, 2)
    sortColors(nums)
}