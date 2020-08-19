package _101_150.leetcode121

fun maxProfit(prices: IntArray): Int {
    if (prices.size <= 1) {
        return 0
    }

    var min = Int.MAX_VALUE
    var profit = 0
    for (price in prices) {
        if (price < min) {
            min = price
        } else {
            val currentProfit = price - min
            if (currentProfit > profit) {
                profit = currentProfit
            }
        }
    }

    return profit
}

fun main() {
    println(maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
}