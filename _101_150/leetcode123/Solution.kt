package _101_150.leetcode123

data class Key(val day: Int, val status: Int, val k: Int)

fun maxProfit(prices: IntArray): Int {
    if (prices.size <= 1) {
        return 0
    }

    return dfs(prices, 0, 0, 0, 2, HashMap())
}

fun dfs(prices: IntArray, day: Int, status: Int, k: Int, targetK: Int, map: MutableMap<Key, Int>): Int {
    val key = Key(day, status, k)
    if (map.containsKey(key)) {
        return map[key]!!
    }

    if (day == prices.size || k == targetK) {
        return 0
    }
    var a = 0
    var b = 0
    var c = 0
    a = dfs(prices, day + 1, status, k, targetK, map)



//  购入
    if (status == 0) {
        b = dfs(prices, day + 1, 1, k, targetK, map) - prices[day]
    } else {
        c =  dfs(prices, day + 1, 0, k + 1, targetK, map) + prices[day]
    }
    map[key] = Math.max(a, Math.max(b, c))
    return map[key]!!
}

fun main() {
    println(maxProfit(intArrayOf(3,3,5,0,0,3,1,4)))
}