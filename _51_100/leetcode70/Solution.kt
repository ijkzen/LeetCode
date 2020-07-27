package _51_100.leetcode70

fun climbStairs(n: Int): Int {
    if (n == 1 || n == 0) {
        return 1
    }

    val a = (1 + Math.sqrt(5.0)) / 2
    val b = (1 - Math.sqrt(5.0)) / 2

    return ((Math.pow(a, n + 1.toDouble()) - Math.pow(b, n + 1.toDouble())) / Math.sqrt(5.0)).toInt()
}

fun main() {
    println(climbStairs(3))
}