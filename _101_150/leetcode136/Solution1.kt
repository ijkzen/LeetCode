package _101_150.leetcode136

fun singleNumber1(nums: IntArray): Int {
    var single = 0
    for (num in nums) {
        single = single xor num
    }

    return single
}