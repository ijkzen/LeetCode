package _50.leetcode43

/**
 * @author ijkzen
 * @since 2020/5/24
 */
fun multiply(num1: String, num2: String): String {
    if (num1 == "0" || num2 == "0") {
        return "0"
    }

    val result = IntArray(num1.length + num2.length) { 0 }
    for (i in num2.length - 1 downTo 0) {
        for (j in num1.length - 1 downTo 0) {
            val n1 = num1[j] - '0'
            val n2 = num2[i] - '0'
            val subSum = (result[i + j + 1] + n1 * n2)
            result[i + j + 1] = subSum % 10
            result[i + j] += subSum / 10
        }
    }

    val builder = StringBuilder()
    result.forEachIndexed { index, i ->
        if (index == 0 && i == 0) {
        } else {
            builder.append(i)
        }
    }

    return builder.toString()
}

fun main() {
    println(multiply("123", "45"))
}