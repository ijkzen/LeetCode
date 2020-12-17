package _101_150.leetcode132

fun minCut(s: String): Int {
    if (s.length <= 1) {
        return 0
    }

    val length = s.length
    val dp = Array<BooleanArray>(length) { BooleanArray(length) { false } }

    for (right in 0 until length) {
        for (left in 0..right) {
            if (s[left] == s[right] && (right - left <= 2 || dp[left + 1][right - 1])) {
                dp[left][right] = true
            }
        }
    }

    val result = IntArray(length){0}

    for (i in 1 until length) {
        if (dp[0][i]) {
            result[i] = 0
        } else {
            for (j in i downTo 1) {
                if (dp[j][i]) {
                    if (result[i] == 0 || result[j-1] + 1 <= result[i]) {
                        result[i] = result[j-1] + 1
                    }
                }
            }
        }
    }

    return result[length - 1]
}

fun main() {
    println(minCut("aabcaba"))
}