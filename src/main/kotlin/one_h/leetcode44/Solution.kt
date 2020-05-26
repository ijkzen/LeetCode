package one_h.leetcode44

fun isMatch(s: String, p: String): Boolean {

    val dp = Array<BooleanArray>(s.length + 1) {
        BooleanArray(p.length + 1)
    }
    dp[0][0] = true
    for (i in 1..p.length) {
        dp[0][i] = dp[0][i - 1] && p[i - 1] == '*';
    }

    for (i in s.indices) {
        val currentS = s[i]
        for (j in p.indices) {
            when (p[j]) {
                '?' -> {
                    dp[i + 1][j + 1] = dp[i][j]
                }
                '*' -> {
                    dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j]
                }
                currentS -> {
                    dp[i + 1][j + 1] = dp[i][j]
                }
                else -> {
                    dp[i + 1][j + 1] = false
                }
            }
        }
    }

    return dp[s.length][p.length]
}

fun main() {
    print(isMatch("aabbbc", "*"))
}