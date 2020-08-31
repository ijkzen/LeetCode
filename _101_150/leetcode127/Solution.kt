package _101_150.leetcode127

fun ladderLength(beginWord: String, endWord: String, wordList: List<String>): Int {

    return if (wordList.contains(endWord)) {
        ladderLength(beginWord, endWord, ArrayList(wordList), 1)
    } else {
        0
    }
}

fun ladderLength(beginWord: String, endWord: String, wordList: MutableList<String>, current: Int): Int {
    if (isMinDiff(beginWord, endWord)) {
        return current + 1
    }

    val list = ArrayList<String>()
    for (target in wordList) {
        if (isMinDiff(beginWord, target)) {
            list.add(target)
        }
    }

    if (list.isEmpty()) {
        return 0
    } else {
        val resultList = ArrayList<Int>()
        for (begin in list) {
            val newWordList = ArrayList(wordList)
            newWordList.remove(begin)
            resultList.add(ladderLength(begin, endWord, newWordList, current + 1))
        }

        resultList.sort()
        resultList.removeIf { it == 0 }
        return if (resultList.isEmpty()) {
            0
        } else {
            resultList[0]
        }
    }
}

fun isMinDiff(origin: String, target: String): Boolean {
    val length = Math.min(origin.length, target.length)
    var mount = 0
    for (i in 0 until length) {
        if (origin[i] != target[i]) {
            mount++
        }
    }

    return mount == 1
}

fun main() {
    val begin = "hit"
    val end = "cog"
    val wordList = listOf("hot","dot","dog","lot","log","cog")
    println(ladderLength(begin, end, wordList))
}
