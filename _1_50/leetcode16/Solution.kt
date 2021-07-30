package _1_50.leetcode16

/**
 * 执行耗时:208 ms,击败了86.44% 的Kotlin用户
 * 内存消耗:36.1 MB,击败了37.29% 的Kotlin用户
 */
fun threeSumClosest(nums: IntArray, target: Int): Int {
    var min: Int? = null
    var minDelta = Int.MAX_VALUE
    nums.sort()

    for (i in 0..(nums.size - 3)) {

        if (i > 0 && nums[i] == nums[i - 1]) {
            continue
        }

        var left = i + 1
        var right = nums.size - 1
        var loopMin: Int? = null
        var loopMinDelta = Int.MAX_VALUE
        while (left < right) {
            val loopResult = nums[i] + nums[left] + nums[right]
            val delta = getDelta(loopResult, target)

            when {
                delta >= loopMinDelta -> {
                    if (loopResult > target) {
                        right--
                    } else {
                        left++
                    }
                }
                else -> {
                    loopMinDelta = delta
                    loopMin = loopResult
                    if (loopMin > target) {
                        right--
                    } else {
                        left++
                    }
                }
            }
        }

        if (loopMinDelta < minDelta) {
            minDelta = loopMinDelta
            min = loopMin
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
    println(threeSumClosest(intArrayOf(-55, -24, -18, -11, -7, -3, 4, 5, 6, 9, 11, 23, 33), 0))
}