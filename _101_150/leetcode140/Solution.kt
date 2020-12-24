package _101_150.leetcode140

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

fun wordBreak1(s: String, wordDict: List<String>): Boolean {
    if (wordDict.isEmpty()) {
        return false
    }

    val wordSet = HashSet(wordDict)
    val dp = BooleanArray(s.length + 1) { false }
    dp[0] = true
    for (i in 1..s.length) {
        for (j in 0..i) {
            if (dp[j] && wordSet.contains(s.substring(j, i))) {
                dp[i] = true
            }
        }
    }

    return dp[s.length]
}

fun wordBreak(s: String, wordDict: List<String>): List<String> {

    if (!wordBreak1(s, wordDict)) {
        return  arrayListOf()
    }

    val wordSet = HashSet<String>()
    val charSet = HashSet<Char>()
    val lengthSet = HashSet<Int>()
    val lengthList = ArrayList<Int>()

    for (word in wordDict) {
        wordSet.add(word)
        word.toCharArray().forEach { charSet.add(it) }
        lengthSet.add(word.length)
    }

    for (length in lengthSet) {
        lengthList.add(length)
    }

    lengthList.sortDescending()
    val result = arrayListOf<String>()
    dfs(s, 0, LinkedList(), result, wordSet, lengthList)

    return result
}

fun dfs(target: String, start: Int, queue: MutableList<String>, result: MutableList<String>, set: Set<String>, lengthList: List<Int>) {

    if (start == target.length) {
        val builder = StringBuilder()

        for (i in queue.indices) {
            if (i == 0) {
                builder.append(queue[i])
            } else {
                builder.append(" ${queue[i]}")
            }
        }

        result.add(builder.toString())
        return
    }

    for (length in lengthList) {
        if (start + length > target.length) {
            continue
        }

        val case = target.substring(start, start + length)
        if (set.contains(case)) {
            queue.add(case)
            dfs(target, start + length, queue, result, set, lengthList)
            queue.removeAt(queue.size - 1)
        }
    }
}

fun main() {
    val target = "leetcode"
    val dict = arrayListOf("leet", "code")

    println(wordBreak(target, dict))
}
