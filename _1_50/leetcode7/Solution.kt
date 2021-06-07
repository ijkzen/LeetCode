package _1_50.leetcode7

/**
 * 执行耗时156ms，超越94.30%
 * 时间复杂度为常量
 */
fun reverse(x: Int): Int {
    var x1 = x
    var rev = 0
    while (x1 != 0) {
        val pop = x1 % 10
        x1 /= 10
        if (rev > Int.MAX_VALUE / 10 || rev == Int.MAX_VALUE / 10 && pop > Int.MAX_VALUE % 10) {
            rev = 0
            break
        } else if (rev < Int.MIN_VALUE / 10 || rev == Int.MIN_VALUE / 10 && x1 < Int.MIN_VALUE % 10) {
            rev = 0
            break
        }
        rev = rev * 10 + pop
    }
    return rev
}

fun main() {
    //-2147483648
    println(reverse(1563847412))
}