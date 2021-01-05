package _1_50.leetcode33

fun search(nums: IntArray, target: Int): Int {
    if (nums.size < 4) {
        for (i in nums.indices) {
            if (nums[i] == target) {
                return i
            }
        }
        return -1
    }

    val pointIndex = findPoint(nums, 0, 0, nums.size - 1, nums.size - 1)

    if (pointIndex == -1) {
        return findTarget(nums, 0, nums.size - 1, false, target)
    }

    return when {
        nums[0] > target -> {
            findTarget(nums, pointIndex + 1, nums.size - 1, true, target)
        }
        nums[0] == target -> {
            0
        }
        else -> {
            findTarget(nums, 0, pointIndex, false, target)
        }
    }
}

fun findPoint(nums: IntArray, leftStart: Int, leftEnd: Int, rightStart: Int, rightEnd: Int): Int {
    if (leftEnd >= rightStart) {
        return -1
    }

    return if (nums[leftEnd] > nums[rightStart]) {
        val currentSize = rightStart - leftEnd + 1
        when {
            currentSize == 1 -> {
                leftEnd
            }
            currentSize < 4 -> {
                for (i in rightStart downTo leftEnd + 1) {
                    if (nums[i - 1] > nums[i]) {
                        return i - 1
                    }
                }
                -1
            }
            else -> {
                val step = (currentSize / 4.0).toInt()
                findPoint(nums, leftEnd, leftEnd + step, rightStart - step, rightStart)
            }
        }
    } else {
        val leftResult = findPoint(nums, leftStart, leftStart, leftEnd, leftEnd)
        val rightResult = findPoint(nums, rightStart, rightStart, rightEnd, rightEnd)

        if (leftResult == -1) rightResult else leftResult
    }
}

fun findTarget(nums: IntArray, left: Int, right: Int, isRight: Boolean, target: Int): Int {
    if (left > right) {
        return -1
    }
    if (left == right) {
        return if (nums[left] == target) {
            left
        } else {
            -1
        }
    }

    if (right - left == 1) {
        if (nums[left] == target) {
            return left
        }

        if (nums[right] == target) {
            return right
        }

        return -1
    }

    val middle = (left + right) / 2 + if (isRight) 1 else 0
    return when {
        nums[middle] == target -> {
            middle
        }
        nums[middle] > target -> {
            findTarget(nums, left, middle, false, target)
        }
        else -> {
            findTarget(nums, middle, right, true, target)
        }
    }
}

fun main() {

    val nums = intArrayOf(9, 0, 2, 7, 8)
    println(search(nums, 3))
}