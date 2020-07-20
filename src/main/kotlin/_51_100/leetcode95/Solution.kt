package _51_100.leetcode95

fun numTrees(n: Int): Int {
    var c :Long= 1
    for (i in 1..n) {
        c = c * (4 * i - 2) / (i + 1)
    }
    return c.toInt()
}

fun main() {
    println(numTrees(19))
}