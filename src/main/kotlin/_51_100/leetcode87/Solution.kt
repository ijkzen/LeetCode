package _51_100.leetcode87

fun isScramble(s1: String, s2: String): Boolean {
    if (s1.length != s2.length) {
        return false
    }

    val n = s1.length

    val dp = Array<Array<BooleanArray>>(n) {
        Array<BooleanArray>(n) {
            BooleanArray(n + 1)
        }
    }

    for (i in 0 until n) {
        for (j in 0 until n) {
            dp[i][j][1] = s1[i] == s2[j]
        }
    }

    for (length in 2..n) {
        for (i in 0..n - length) {
            for (j in 0..n - length) {
                for (k in 1 until length) {
                    if (dp[i][j][k] && dp[i + k][j + k][length - k]) {
                        dp[i][j][length] = true
                        break
                    }

                    if (dp[i][j + length - k][k] && dp[i + k][j][length - k]) {
                        dp[i][j][length] = true
                        break
                    }
                }
            }
        }
    }

    return dp[0][0][n]
}

fun main() {
    println(isScramble("great", "rgeat"))
}