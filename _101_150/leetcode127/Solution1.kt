package _101_150.leetcode127

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun ladderLength1(beginWord: String, endWord: String, wordList: List<String>): Int {

    val wordLength = beginWord.length

    val map = HashMap<String, MutableList<String>>()

    wordList.forEach {
        for (i in 0 until wordLength) {
            val key = it.substring(0, i) + "*" + it.substring(i + 1, wordLength)
            val list = map.getOrDefault(key, ArrayList())
            list.add(it)
            map[key] = list
        }
    }

    val workQueue: Queue<Pair<MutableList<String>, Int>> = LinkedList()
    val path = ArrayList<String>().apply { add(beginWord) }
    workQueue.add(Pair(path, 1))

    val visited = HashMap<String, Boolean>()
    visited[beginWord] = true

    while (workQueue.isNotEmpty()) {
        val pair = workQueue.poll()
        val originPath = pair.first
        val word = originPath[originPath.size - 1]
        val step = pair.second

        for (i in 0 until wordLength) {
            val key = word.substring(0, i) + "*" + word.substring(i + 1, wordLength)
            val list = map.getOrDefault(key, ArrayList())

            for (next in list) {
                if (next == endWord) {
                    originPath.add(next)
                    println(originPath)
                    return step + 1
                }

                if (!visited.getOrDefault(next, false)) {
                    visited[next] = true
                    val newPath = ArrayList(originPath)
                    newPath.add(next)
                    workQueue.offer(Pair(newPath, step + 1))
                }
            }
        }
    }

    return 0
}

fun main() {
    val begin = "qa"
    val end = "sq"
    val wordList = listOf("si", "go", "se", "cm", "so", "ph", "mt", "db", "mb", "sb", "kr", "ln", "tm", "le", "av", "sm", "ar", "ci", "ca", "br", "ti", "ba", "to", "ra", "fa", "yo", "ow", "sn", "ya", "cr", "po", "fe", "ho", "ma", "re", "or", "rn", "au", "ur", "rh", "sr", "tc", "lt", "lo", "as", "fr", "nb", "yb", "if", "pb", "ge", "th", "pm", "rb", "sh", "co", "ga", "li", "ha", "hz", "no", "bi", "di", "hi", "qa", "pi", "os", "uh", "wm", "an", "me", "mo", "na", "la", "st", "er", "sc", "ne", "mn", "mi", "am", "ex", "pt", "io", "be", "fm", "ta", "tb", "ni", "mr", "pa", "he", "lr", "sq", "ye")
    println(ladderLength1(begin, end, wordList))
}