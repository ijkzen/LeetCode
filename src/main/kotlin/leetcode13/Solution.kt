package leetcode13

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