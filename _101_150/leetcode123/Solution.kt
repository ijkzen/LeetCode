package _101_150.leetcode123

fun maxProfit(prices: IntArray): Int {
    if (prices.size <= 1) {
        return 0
    }

    val deltaList = ArrayList<Int>()
    var currentMin = prices[0]
    for (i in 1 until prices.size) {
        if (prices[i] < prices[i - 1]) {
            deltaList.add(prices[i - 1] - currentMin)
            currentMin = prices[i]
        }

        if (i == prices.size - 1) {
            deltaList.add(prices[i] - currentMin)
        }
    }

    deltaList.removeIf { it < 0 }
    deltaList.sortDescending()

    return when {
        deltaList.size == 1 -> {
            deltaList[0]
        }
        deltaList.size >= 2 -> {
            deltaList[0] + deltaList[1]
        }
        else -> {
            0
        }
    }
}

fun main() {
    println(maxProfit(intArrayOf(1,2,4,2,5,7,2,4,9,0)))
}