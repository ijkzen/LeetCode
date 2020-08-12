package _101_150.leetcode115

fun numDistinct(s: String, t: String): Int {
    if (s.length < t.length) {
        return 0
    }

    val sLength = s.length
    val tLength = t.length
    val dp = Array<IntArray>(tLength + 1) {
        IntArray(sLength + 1)
    }

    for (i in dp.indices) {
        dp[i][0] = 0
    }

    for (j in dp[0].indices) {
        dp[0][j] = 1
    }

    for (i in 1..tLength) {
        for (j in 1..sLength) {
            if (t[i - 1] == s[j - 1]) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j - 1]
            } else {
                dp[i][j] = dp[i][j - 1]
            }
        }
    }

    return dp[tLength][sLength]
}

fun main() {
    println(numDistinct("babgbag", "bag"))
}