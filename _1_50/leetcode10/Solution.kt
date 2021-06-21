package _1_50.leetcode10

/**
 * 执行耗时:200 ms,击败了73.33% 的Kotlin用户
 * 内存消耗:35.2 MB,击败了40.00% 的Kotlin用户
 */
fun isMatch(text: String, pattern: String): Boolean {
    val textLength = text.length
    val patternLength = pattern.length
    val dp = Array(textLength + 1) { BooleanArray(patternLength + 1) }
    dp[textLength][patternLength] = true

    for (i in textLength downTo 0) {
        for (j in (patternLength - 1) downTo 0) {
            val firstMatch = (i < textLength && (pattern[j] == text[i] || pattern[j] == '.'))

            if (j + 1 < patternLength && pattern[j + 1] == '*') {
                val result = dp[i][j + 2] || firstMatch && dp[i + 1][j]
                dp[i][j] = result
            } else {
                val result = firstMatch && dp[i + 1][j + 1]
                dp[i][j] = result
            }
        }
    }

    return dp[0][0]
}

fun main() {
    println(isMatch("abbb", "ab*"))
}