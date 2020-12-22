package _101_150.leetcode137

fun singleNumber(nums: IntArray): Int {
    var a = 0
    var b = 0

    for (num in nums) {
        b = (b xor num) and a.inv()
        a = (a xor num) and b.inv()
    }

    return b
}