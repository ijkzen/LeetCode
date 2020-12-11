package _101_150.leetcode126

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

fun findLadders(beginWord: String, endWord: String, wordList: List<String>): List<List<String>> {

    if (wordList.isEmpty()) {
        return arrayListOf()
    }

    var length = 0
    val wordId = HashMap<String, Int>()
    val idWord = ArrayList<String>()

    for (word in wordList) {
        if (!wordId.containsKey(word)) {
            wordId[word] = length++
            idWord.add(word)
        }
    }

    if (!wordId.containsKey(endWord)) {
        return arrayListOf()
    }

    if (!wordId.containsKey(beginWord)) {
        wordId[beginWord] = length++
        idWord.add(beginWord)
    }

    val edges = HashMap<Int, MutableSet<Int>>()
    for (i in idWord.indices) {
        edges[i] = mutableSetOf()
        for (j in idWord.indices) {
            if (isDifference(idWord[i], idWord[j])) {
                addEdge(edges, i, j)
                addEdge(edges, j, i)
            }
        }
    }

    val cost = IntArray(wordId.size) {
        Int.MAX_VALUE
    }
    cost[wordId[beginWord]!!] = 0

    val q = LinkedList<ArrayList<Int>>()
    val result = ArrayList<ArrayList<String>>()

    val destId = wordId[endWord]

    val beginList = arrayListOf<Int>(wordId[beginWord]!!)
    q.add(beginList)

    while (q.isNotEmpty()) {
        val queue = q.poll()
        val last = queue[queue.size - 1]

        if (last == destId) {
            val tmpList = ArrayList<String>()
            queue.forEach {
                tmpList.add(idWord[it])
            }
            result.add(tmpList)
        } else {
            val edge = edges[last]!!

            edge.forEach {
                if (cost[last] + 1 <= cost[it]) {
                    cost[it] = cost[last] + 1
                    val tmp = ArrayList(queue)
                    tmp.add(it)
                    if (queueAddCheck(result, tmp)) {
                        q.add(tmp)
                    }
                }
            }
        }
    }

    return result
}

fun addEdge(hashMap: HashMap<Int, MutableSet<Int>>, i: Int, j: Int) {
    hashMap[i]?.add(j)
}

fun queueAddCheck(result: ArrayList<ArrayList<String>>, queue: ArrayList<Int>): Boolean {
    return if (result.isEmpty()) {
        true
    } else {
        result[0].size >= queue.size
    }
}

fun isDifference(a: String, b: String): Boolean {
    return if (a.length != b.length) {
        false
    } else {
        var count = 0
        for (i in a.indices) {
            if (a[i] != b[i]) {
                count++
                if (count > 1) {
                    break
                }
            }
        }

        count == 1
    }
}

fun main() {
    println(findLadders("hot", "dog", arrayListOf("hot", "dog")))
}
