package _1_50.leetcode13

/**
 * 执行耗时:196 ms,击败了94.87% 的Kotlin用户
 * 内存消耗:34.8 MB,击败了66.67% 的Kotlin用户
 */
fun romanToInt(s: String): Int {
    var sum = 0
    var isCombine = false

    for (i in s.indices) {
        if (i <= s.length - 2) {
            val tmp1 = number(s.substring(i, i + 1))
            val tmp2 = number(s.substring(i + 1, i + 2))
            sum += if (tmp1 < tmp2) {
                isCombine = true
                (tmp2 - tmp1)
            } else {
                if (isCombine) {
                    isCombine = false
                    0
                } else {
                    tmp1
                }
            }
        } else {
            if (!isCombine) {
                sum += number(s.substring(i, i + 1))
            }
        }
    }

    return sum
}

fun number(number: String): Int {
    return when (number) {
        "I" -> 1
        "V" -> 5
        "X" -> 10
        "L" -> 50
        "C" -> 100
        "D" -> 500
        "M" -> 1000
        else -> 0
    }

}

fun main() {
    println(romanToInt("MCMXCIV"))
}