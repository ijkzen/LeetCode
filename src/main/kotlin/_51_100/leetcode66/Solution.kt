package _51_100.leetcode66

import _50.leetcode1.string

fun plusOne(digits: IntArray): IntArray {
    return plus(digits, digits.size - 1)
}

fun plus(digits: IntArray, index: Int): IntArray {
    return if (digits[index] == 9) {
        digits[index] = 0
        if (index == 0) {
            val result = IntArray(digits.size + 1)
            result[0] = 0
            for (i in digits.indices) {
                result[i + 1] = digits[i]
            }
            plus(result, index)
        } else {
            plus(digits, index - 1)
        }
    } else {
        digits[index] += 1
        digits
    }
}

fun main() {
    println(plusOne(intArrayOf(9,9)).string())
}