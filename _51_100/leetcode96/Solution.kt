package _51_100.leetcode96

fun isInterleave(s1: String, s2: String, s3: String): Boolean {
    if (s1.length + s2.length != s3.length) {
        return false
    }

    val m = s1.length
    val n = s2.length

    val dp = Array<BooleanArray>(m + 1) {
        BooleanArray(n + 1)
    }

    dp[0][0] = true
    for (i in 0 .. m) {
        for (j in 0 .. n) {
            if (i > 0) {
                dp[i][j] = dp[i][j] || dp[i - 1][j] && s1[i - 1] == s3[i + j - 1]
            }

            if (j > 0) {
                dp[i][j] = dp[i][j] || dp[i][j - 1] && s2[j - 1] == s3[i + j - 1]
            }
        }
    }


    return dp[m][n]
}

fun main() {
    println(isInterleave("aabcc", "dbbca", "aadbbcbcac"))
}