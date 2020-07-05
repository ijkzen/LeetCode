package _51_100.leetcode80

fun removeDuplicates(nums: IntArray): Int {
    if (nums.size <= 2) {
        return nums.size
    }

    var index = 0
    for (i in 1 until nums.size) {
        if (nums[index] != nums[i]) {
            nums[++index] = nums[i]
        } else {
            if (index == 0) {
                nums[++index] = nums[i]
            } else {
                if (nums[index] != nums[index - 1]) {
                    nums[++index] = nums[i]
                }
            }
        }
    }


    return index + 1
}

fun main() {
    println(removeDuplicates(intArrayOf(1, 1, 2, 2, 2, 3)))
}