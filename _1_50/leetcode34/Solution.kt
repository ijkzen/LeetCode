package _1_50.leetcode34

import _1_50.leetcode28.string

fun searchRange(nums: IntArray, target: Int): IntArray {

    val point = find(nums, 0, nums.size - 1, target)
    return if (point == -1) {
        intArrayOf(-1, -1)
    } else {
        findRange(nums, point)
    }
}

fun find(nums: IntArray, left: Int, right: Int, target: Int): Int {
    return when {
        left > right -> {
            -1
        }
        left == right -> {
            return if (nums[left] == target) {
                left
            } else {
                -1
            }
        }
        else -> {
            val middle = (left + right) / 2
            when {
                nums[middle] > target -> {
                    find(nums, left, middle, target)
                }
                nums[middle] < target -> {
                    find(nums, middle + 1, right, target)
                }
                else -> {
                    middle
                }
            }
        }
    }
}

fun findRange(nums: IntArray, point: Int): IntArray {
    var left = point
    var right = point

    val target = nums[point]

    while (left >= 0 && nums[left] == target) {
        left--
    }

    if (left != point) {
        left++
    }

    while (right < nums.size && nums[right] == target) {
        right++
    }

    if (right != point) {
        right--
    }


    return intArrayOf(left, right)

}

fun main() {
    val range = intArrayOf(1, 3, 4, 4, 8, 8, 9)
    println(searchRange(range, 8).string())
}