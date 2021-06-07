package _1_50.leetcode6

import java.lang.StringBuilder

/**
 * 运行时间216ms，超越100%
 * 时间复杂度 O(n) = n，直接构造了通项，所以要快许多；
 */
fun convert1(s: String, numRows: Int): String {
    if (numRows == 1) {
        return s
    }

    val result = CharArray(s.length)
    var index = 0
    val internal = numRows - 1
    for (i in 0 until numRows) {
        var j = i

        while (j < s.length) {
            result[index] = s[j]
            j += 2 * (internal - j % internal)
            index++
        }
    }

    return String(result)
}

fun main() {
    println(convert1("PAYPALISHIRING", 4))
    // "PINALSIGYAHRPI" expected
}