package _1_50.leetcode16

fun threeSumClosest(nums: IntArray, target: Int): Int {
    var min: Int? = null
    nums.sort()

    for (i in nums.indices) {

        if (i > 0 && nums[i] == nums[i - 1]) {
            continue
        }

        var left = i + 1
        var right = nums.size - 1
        while (left < right) {
            val delta = getDelta(nums[i] + nums[left] + nums[right], target)
            val currentDelta = if (min == null) Int.MAX_VALUE else getDelta(min, target)
            when {
                delta == currentDelta -> {
                    if ((nums[i] + nums[left] + nums[right]) > target) {
                        right--
                    } else {
                        left++
                    }
                }
                delta > currentDelta -> {
                    if ((nums[i] + nums[left] + nums[right]) > target) {
                        right--
                    } else {
                        left++
                    }
                }
                else -> {
                    min = nums[i] + nums[left] + nums[right]
                    if (min > target) {
                        right--
                    } else {
                        left++
                    }
                }
            }
        }
    }

    return min!!
}

private fun getDelta(a: Int, b: Int): Int {
    return if (a > b) {
        a - b
    } else {
        b - a
    }
}

fun main() {
    println(threeSumClosest(intArrayOf(4,0,5,-5,3,3,0,-4,-5), -2))
}