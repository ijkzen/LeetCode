package _1_50.leetcode28

import kotlin.text.StringBuilder


fun strStr(haystack: String, needle: String): Int {

    if (haystack.length < needle.length) {
        return -1
    }

    if (needle.isEmpty()) {
        return 0
    }

    val next = createNextArray(needle)
    var i = 0
    var j = 0
    var result = -1
    while (true) {
        if (i < haystack.length) {
            if (haystack[i] == needle[j]) {
                if (j == needle.length - 1) {
                    result = i - j
                    break
                }
                i++
                j++
            } else {
                i = if (j == 0) i + 1 else i
                j = next[if (j == 0) 0 else j - 1]
            }
        } else {
            break
        }
    }

    return result
}

fun IntArray.string(): String {
    val builder = StringBuilder()
    this.iterator().forEach {
        builder.append(it)
        builder.append(",")
    }

    return builder.toString()
}

fun createNextArray(pattern: String): IntArray {
    val next = IntArray(pattern.length)

    next[0] = 0
    for (i in 1 until next.size) {
        if (pattern[i] == pattern[next[i - 1]]) {
            next[i] = next[i - 1] + 1
        } else {
            val secondNext = next[if (next[i - 1] == 0) 0 else next[i - 1] - 1]
            if (secondNext != 0) {
                if (pattern[secondNext] == pattern[i]) {
                    next[i] = secondNext + 1
                } else {
                    next[i] = 0
                }
            } else {
                if (pattern[0] == pattern[i]) {
                    next[i] = 1
                } else {
                    next[i] = 0
                }
            }
        }
    }

    println(next.string())
    return next
}


fun main() {
    println(strStr("hello", "ll"))
}