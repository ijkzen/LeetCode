package _1_50.leetcode6

import java.lang.StringBuilder

/**
 * 运行时间224ms，超越98.31%
 * 时间复杂度 O(n) = n，直接构造了通项，所以要快许多；
 */
fun convert1(s: String, numRows: Int): String {
    if (numRows == 1) {
        return s
    }

    val builder = StringBuilder()
    val internal = numRows - 1
    for (i in 0 until numRows) {
        var j = i

        while (j < s.length) {
            builder.append(s[j])
            j += 2 * (internal - j % internal)
        }
    }

    return builder.toString()
}

fun main() {
    println(convert1("PAYPALISHIRING", 4))
    // "PINALSIGYAHRPI" expected
}