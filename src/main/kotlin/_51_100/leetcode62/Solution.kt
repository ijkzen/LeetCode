package _51_100.leetcode62

val map = HashMap<Int, Int>()

fun uniquePaths(m: Int, n: Int): Int {
    map[0] = 1
    map[1] = 1

    val a = getCount(m - 1)
    val b = getCount(n - 1)

    return getCount(m - 1) * getCount(n - 1)
}

fun getCount(n: Int): Int {
    if (map[n] != null) {
        return map[n]!!
    }

    var result = 0
    for (i in 1..(n / 2)) {
        result += (getCount(i) + getCount(n - i))
    }
    map[n] = result
    return result
}

fun main() {
    println(uniquePaths(7, 3))
}