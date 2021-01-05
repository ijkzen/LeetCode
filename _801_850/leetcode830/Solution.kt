package _801_850.leetcode830

var start = -1
var end = -1

fun largeGroupPositions(s: String): List<List<Int>> {
    if (s.length < 3) {
        return arrayListOf()
    }

    var char: Char = Char.MAX_HIGH_SURROGATE
    val result = ArrayList<ArrayList<Int>>()

    for (i in s.indices) {
        if (s[i] == char) {
            end = i
        } else if (s[i] != char){
            tryAdd(result)

            char = s[i]
            start = i
            end = i
        }

        if (i == s.length - 1) {
            tryAdd(result)
        }
    }

    return result
}

fun tryAdd(result: ArrayList<ArrayList<Int>>) {
    if (end - start >= 2) {
        result.add(arrayListOf(start, end))
    }
}

fun main() {
    println(largeGroupPositions("aabbbbbbcccccyyyyy"))
}