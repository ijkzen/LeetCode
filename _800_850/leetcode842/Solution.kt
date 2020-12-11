package _800_850.leetcode842

import java.math.BigInteger
import java.util.*

fun splitIntoFibonacci(fibonacci: String): List<Int> {
    if (fibonacci.isEmpty() || fibonacci.length < 3) {
        return arrayListOf()
    }

    val result = LinkedList<Int>()
    subSplit(fibonacci, result)
    return result.reversed().toList()
}

fun subSplit(fibonacci: String, deque: LinkedList<Int>) {
    if (fibonacci.isEmpty()) {
        return
    }

    val length = fibonacci.length
    if (deque.isEmpty()) {
        val maxSubLength = fibonacci.length / 3 + 1
        for (i in 1..maxSubLength) {
            val element = fibonacci.substring(length - i, length)
            if (isValid(element)) {
                deque.add(element.toInt())
                subSplit(fibonacci.substring(0, length - i), deque)
            }
        }

        if (deque.size < 3) {
            deque.clear()
        }

    } else if (deque.size == 1) {
        val third = deque.first()
        for (i in 1.."$third".length) {
            val element = fibonacci.substring(length - i, length)
            if (isValid(element) && element.toInt() <= third) {
                deque.add(element.toInt())
                subSplit(fibonacci.substring(0, length - i), deque)
            }
        }

        if (deque.size < 3) {
            deque.clear()
        }
    } else {
        val dequeLength = deque.size
        val third = deque[dequeLength - 2]
        val second = deque[dequeLength - 1]

        val first = "${third - second}"

        if (isValid(first) && fibonacci.endsWith(first)) {
            deque.add(first.toInt())
            subSplit(fibonacci.substring(0, length - first.length), deque)
        } else {
            deque.removeLast()
        }
    }
}

fun isValid(element: String): Boolean {
    if (element.length >= 2 && element[0] == '0') {
        return false
    }

    return BigInteger(element) < BigInteger("${Int.MAX_VALUE}")
}

fun main() {
    println(splitIntoFibonacci("123456579"))
}