package _101_150.leetcode122

fun maxProfit(prices: IntArray): Int {
    if (prices.size <= 1) {
        return 0
    }

    var maxProfit = 0
    for (i in 1 until prices.size) {
        if (prices[i] > prices[i - 1]) {
            maxProfit += prices[i] - prices[i - 1]
        }
    }

    return maxProfit
}

fun main() {
    println(maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
}