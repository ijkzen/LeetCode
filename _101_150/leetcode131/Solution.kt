package _101_150.leetcode131

import java.util.*
import kotlin.collections.ArrayList

lateinit var dp: Array<BooleanArray>

fun partition(input: String): List<List<String>> {
    if (input.isEmpty()) {
        return arrayListOf()
    } else if (input.length == 1) {
        return arrayListOf(arrayListOf(input))
    }

    val result = mutableListOf<List<String>>()
    val length = input.length
    dp = Array(length) {
        BooleanArray(length) { false }
    }

    for (right in input.indices) {
        for (left in 0..right) {
            if (input[left] == input[right] && (right - left <= 2 || dp[left + 1][right - 1])) {
                dp[left][right] = true
            }
        }
    }

    dfs(LinkedList(), result, input, 0, length)

    return result
}

fun dfs(path: MutableList<String>, result: MutableList<List<String>>, input: String, start: Int, end: Int) {
    if (start == end) {
        result.add(ArrayList(path))
        return
    }

    for (i in start until end) {
        if (dp[start][i]) {
            path.add(input.subSequence(start, i + 1) as String)
            dfs(path, result, input, i + 1, end)
            path.removeAt(path.size - 1)
        }
    }
}

fun main() {
    println(partition("aab"))
}