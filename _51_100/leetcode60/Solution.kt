package _51_100.leetcode60

import kotlin.text.StringBuilder

val map = HashMap<Int, Int>()

fun getPermutation(n: Int, k: Int): String {
    val numberLeft = ArrayList<Int>()
    for (i in 1..n) {
        numberLeft.add(i)
    }

    val result = StringBuilder()
    singleItem(numberLeft, n - 1, k, result)

    return result.toString()
}

fun singleItem(numberLeft: MutableList<Int>, rightSize: Int, k: Int, result: StringBuilder) {
    if (rightSize > 0) {
        val factorial = getFactorial(rightSize)
        val nextK = k % factorial
        val currentElementIndex = (k / factorial) - if (nextK == 0) 1 else 0
        val element = numberLeft[currentElementIndex]
        result.append(element)
        numberLeft.remove(element)
        if (nextK == 0) {
            for (i in (numberLeft.size - 1) downTo 0) {
                result.append(numberLeft[i])
            }
            return
        }

        singleItem(numberLeft, rightSize - 1, nextK, result)
    } else {
        result.append(numberLeft[0])
    }
}

fun getFactorial(n: Int): Int {
    return if (map[n] == null) {
        var result: Int = 1

        for (i in 1..n) {
            result *= i
            map[i] = result
        }
        result
    } else {
        map[n]!!
    }
}

fun main() {
    println(getPermutation(4, 12))
}