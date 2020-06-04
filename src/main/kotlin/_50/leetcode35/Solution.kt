package _50.leetcode35

fun searchInsert(nums: IntArray, target: Int): Int {

    val point = find(nums, 0, nums.size - 1, target)
    return if (point == -1) {
        findInsertPoint(nums, 0, nums.size - 1, target)
    } else {
        point
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

fun findInsertPoint(nums: IntArray, left: Int, right: Int, target: Int): Int {
    return when {
        left > right -> {
            -1
        }
        left == right -> {
            if (nums[left] > target) {
                left
            } else {
                left + 1
            }
        }
        else -> {
            if (right - left == 1 && target >= nums[left] && target <= nums[right]) {
                return right
            }

            val middle = (left + right) / 2
            when {
                nums[middle] > target -> {
                    findInsertPoint(nums, left, middle, target)
                }
                nums[middle] < target -> {
                    findInsertPoint(nums, middle + 1, right, target)
                }
                else -> {
                    middle
                }
            }
        }
    }
}

fun main() {
    val range = intArrayOf(1, 3, 5, 7)
    println(searchInsert(range, 6))
}