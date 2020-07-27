package _51_100.leetcode69

fun mySqrt(c: Int): Int {

    if (c == 0) {
        return 0
    }

    return value(c.toDouble(), c, Double.MAX_VALUE)
}

fun value(x: Double, c: Int, lastX: Double): Int {
    return if (Math.abs(lastX - x) < 0.1) {
        x.toInt()
    } else {
        val y = x * x - c
        value(x - y / (2 * x), c, x)
    }
}

fun main() {
    println(mySqrt(0))
}