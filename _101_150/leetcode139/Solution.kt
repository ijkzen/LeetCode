package _101_150.leetcode139

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

fun wordBreak(s: String, wordDict: List<String>): Boolean {
    if (wordDict.isEmpty()) {
        return false
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

    for (char in s) {
        if (!charSet.contains(char)) {
            return false
        }
    }

    for (length in lengthSet) {
        lengthList.add(length)
    }

    lengthList.sortDescending()
    val result = arrayListOf<Deque<String>>()
    dfs(s, 0, LinkedList(), result, wordSet, lengthList)

    return result.isNotEmpty()
}

fun dfs(target: String, start: Int, queue: Deque<String>, result: MutableList<Deque<String>>, set: Set<String>, lengthList: List<Int>) {
    if (result.isNotEmpty()) {
        return
    }

    if (start == target.length) {
        result.add(LinkedList(queue))
        return
    }

    for (length in lengthList) {
        if (start + length > target.length) {
            continue
        }

        val case = target.substring(start, start + length)
        if (set.contains(case)) {
            queue.offer(case)
            dfs(target, start + length, queue, result, set, lengthList)
            queue.removeLast()
        }
    }
}

fun main() {
    val target = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaababaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa"
    val dict = arrayListOf("aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa","ba")

    println(wordBreak(target, dict))
}