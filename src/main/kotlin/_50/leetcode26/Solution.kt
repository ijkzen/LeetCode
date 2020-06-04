package _50.leetcode26

fun removeDuplicates(nums: IntArray): Int {

    var count = 0
    var current = Int.MIN_VALUE
    nums.iterator().forEach {
        if (current != it) {
            nums[count] = it
            count++
            current = it
        }
    }
    return count
}