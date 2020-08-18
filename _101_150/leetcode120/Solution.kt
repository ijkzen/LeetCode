package _101_150.leetcode120

fun minimumTotal(triangle: List<List<Int>>): Int {
    if (triangle.isEmpty()) {
        return 0
    }

    val n = triangle.size
    val dp = Array<IntArray>(n) { IntArray(n) { Int.MAX_VALUE } }
    dp[0][0] = triangle[0][0]
    for (i in 1 until n) {
        for (j in 0..i) {
            if (j == 0) {
                dp[i][j] = dp[i-1][j] + triangle[i][j]
                continue
            }
            dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j]
        }
    }

    return dp[n - 1].min()!!
}

fun main() {
    val triangle = arrayListOf(arrayListOf(2), arrayListOf(3, 4), arrayListOf(5, 6, 7), arrayListOf(4, 1, 8, 3))
    println(minimumTotal(triangle))
}