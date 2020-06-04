package _50.leetcode29

fun divide(dividend: Int, divisor: Int): Int {

    if (dividend == Int.MIN_VALUE && divisor == -1) {
        return Int.MAX_VALUE
    }


    var isMinus = false

    if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) {
        isMinus = true
    }

    var v1 = dividend
    var v2 = divisor
    if (dividend < 0) {
        v1 = 0 - dividend
    }

    if (divisor < 0) {
        v2 = 0 - divisor
    }

    var count = 0
    while (v1 - v2 >= 0) {
        count++
        v1 -= v2
    }

    return if (isMinus) 0 - count else count
}