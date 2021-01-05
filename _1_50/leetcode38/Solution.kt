package _1_50.leetcode38

import java.util.*

/**
 * @author ijkzen
 * @since 2020/5/21
 */

fun countAndSay(n: Int): String {
    return getResult(n, 0, "1")
}

fun getResult(target: Int, count: Int, currentResult: String): String {
    val tmp = LinkedList<LinkedList<Char>>()
    var lastChar: Char? = null
    for (i in currentResult.indices) {
        if (currentResult[i] == lastChar) {
            tmp[tmp.size - 1].add(currentResult[i])
        } else {
            val subList = LinkedList<Char>()
            subList.add(currentResult[i])
            tmp.add(subList)
        }
        lastChar = currentResult[i]
    }

    val builder = StringBuilder()
    for (subList in tmp) {
        builder.append(subList.size)
        builder.append(subList[0])
    }

    return if (target == count + 1) {
        currentResult
    } else {
        getResult(target, count + 1, builder.toString())
    }
}

fun main() {
    println(countAndSay(4))
}