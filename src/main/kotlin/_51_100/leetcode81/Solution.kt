package _51_100.leetcode81

fun search(nums: IntArray, target: Int): Boolean {
    if (nums.isEmpty()) {
        return false
    }

    if (nums.size == 1) {
        return nums[0] == target
    }

    val maxIndex = getSpecialPoint(nums, 0, nums.size - 1)
    if (target > nums[maxIndex]) {
        return false
    }

    if (maxIndex == nums.size - 1) {
        if (target < nums[0]) {
            return false
        }
    } else {
        if (target < nums[maxIndex + 1]) {
            return false
        }
    }

    return if (maxIndex == nums.size - 1) {
        findTarget(nums, 0, maxIndex, target)
    } else {
        findTarget(nums, 0, maxIndex, target) || findTarget(nums, maxIndex + 1, nums.size - 1, target)
    }

}

fun getSpecialPoint(nums: IntArray, start: Int, end: Int): Int {
    if (end - start == 1 ) {
        return if (nums[start] >= nums[end]) {
            start
        } else {
            end
        }
    }

    if (start == end) {
        return start
    }

    val middle = (start + end) / 2
    return if (nums[start] > nums[middle]) {
        getSpecialPoint(nums, start, middle)
    } else {
        getSpecialPoint(nums, middle, end)
    }
}

fun findTarget(nums: IntArray, start: Int, end: Int, target: Int): Boolean {
    if (end - start <= 1) {
        return nums[start] == target || nums[end] == target
    }

    val middle = (start + end) / 2
    return if (nums[middle] > target) {
        findTarget(nums, start, middle, target)
    } else {
        findTarget(nums, middle, end, target)
    }
}

fun main() {
    val nums = intArrayOf(1,3)
    println(search(nums, 0))
}