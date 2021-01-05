package _501_550.leetcode509

val map = HashMap<Int, Int>().apply {
    put(0, 0)
    put(1, 1)
    put(2, 1)
}


fun fib(n: Int): Int {
    if (map[n] != null) {
        return map[n]!!
    }

    val result = fib(n - 2) + fib(n - 1)
    map[n] = result

    return result
}

fun main() {
    println(fib(4))
    println(fib(5))
    println(fib(6))
    println(fib(7))
    println(fib(8))
}