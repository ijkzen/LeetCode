package _501_550.leetcode509

fun fib1(n: Int): Int {
    val sqrt5 = Math.sqrt(5.0)

    return (
            (
                    Math.pow((1 + sqrt5) / 2, n.toDouble())
                    -
                    Math.pow((1 - sqrt5) / 2, n.toDouble())
            )
               /
               sqrt5
            )
            .toInt()
}

fun main() {
    println(fib1(8))
}