package _51_100.leetcode91

fun numDecodings(s: String): Int {
    if (s.isEmpty() || s[0] == '0') {
        return 0
    }
    val dp = IntArray(s.length)
    dp[0] = 1

    // init dp[1]
    if (s.length > 1) {
        val secondChar = s[1]
        if (secondChar == '0') {
            if (s[0] == '1' || s[0] == '2') {
                dp[1] = 1
            } else {
                return 0
            }
        } else {
            val value = s.substring(0, 2).toInt()
            if (value <= 26) {
                dp[1] = 2
            } else {
                dp[1] = 1
            }
        }
    }

    if (s.length > 2) {
        for (i in 2 until s.length) {
            if (s[i] == '0' && s[i - 1] == '0') {
                return 0
            }

            if (s[i - 1] == '0' && s[i] != '0') {
                dp[i] = dp[i - 1]
                continue
            }

            if (s[i] == '0') {
                if (s[i - 1] == '1' || s[i - 1] == '2') {
                    dp[i] = dp[i-2]
                    continue
                } else {
                    return 0
                }
            }

            val value = s.substring(i - 1, i + 1).toInt()
            if (value <= 26) {
                dp[i] = dp[i - 1] + dp[i - 2]
            } else {
                dp[i] = dp[i - 1]
            }
        }
    }

    return dp[dp.size - 1]
}

fun main() {
    println(numDecodings("130"))
}