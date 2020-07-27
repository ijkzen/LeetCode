package _51_100.leetcode62

import java.math.BigInteger

val map = HashMap<Int, BigInteger>()

fun uniquePaths(m: Int, n: Int): Int {
    map[0] = BigInteger.ONE
    map[1] = BigInteger.ONE
    return (getFactorial(m + n - 2) / getFactorial(m - 1) / getFactorial(n - 1)).toInt()
}


fun getFactorial(n: Int): BigInteger {

    return if (map[n] != null) {
        map[n]!!
    } else {
        val result = getFactorial(n - 1).multiply(BigInteger("$n"))
        map[n] = result
        result
    }

}

fun main() {
    println(uniquePaths(23, 12))
}