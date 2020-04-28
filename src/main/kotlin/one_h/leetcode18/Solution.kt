package one_h.leetcode18

import java.util.*
import kotlin.collections.ArrayList

fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    val result = ArrayList<LinkedList<Int>>()
    nums.sort()

    for (i in 0..(nums.size - 4)) {

        if (i > 0 && nums[i] == nums[i - 1]) {
            continue
        }

        for (j in (i + 1)..(nums.size - 3)) {

            if (j > i + 1 && nums[j] == nums[j - 1]) {
                continue
            }

            var left = j + 1
            var right = nums.size - 1
            while (left < right) {
                val tmp = nums[i] + nums[j] + nums[left] + nums[right]
                when {
                    tmp == target -> {
                        val list = LinkedList<Int>()
                        list.add(nums[i])
                        list.add(nums[j])
                        list.add(nums[left])
                        list.add(nums[right])
                        result.add(list)

                        while (left < right && (nums[left] == nums[left + 1])) {
                            left++
                        }

                        while (left < right && nums[right] == nums[right - 1]) {
                            right--
                        }

                        left++
                        right--
                    }
                    tmp > target -> {
                        right--
                    }
                    else -> {
                        left++
                    }
                }
            }
        }

    }

    return result
}

fun main() {
    println(fourSum(intArrayOf(-3, -2, -1, 0, 0, 1, 2, 3), 0))
}