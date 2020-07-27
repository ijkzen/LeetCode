package _51_100.leetcode72

fun minDistance(word1: String, word2: String): Int {

    if (word1.isEmpty()) {
        return word2.length
    }

    if (word2.isEmpty()) {
        return word1.length
    }

    val long = if (word1.length >= word2.length) word1 else word2
    val short = if (word1.length < word2.length) word1 else word2

    val width = long.length + 1
    val height = short.length + 1

    val matrix = Array<IntArray>(height) {
        IntArray(width)
    }

    for (i in 0 until width) {
        matrix[0][i] = i
    }

    for (i in 0 until height) {
        matrix[i][0] = i
    }

    for (i in 1 until height) {
        for (j in 1 until width) {
            matrix[i][j] = min(
                matrix[i - 1][j] + 1,
                matrix[i][j - 1] + 1,
                matrix[i - 1][j - 1] + if (short[i - 1] == long[j - 1]) 0 else 1
            )
        }
    }


    return matrix[height - 1][width - 1]
}

fun min(a: Int, b: Int, c: Int): Int {
    return a.coerceAtMost(b).coerceAtMost(c)
}

fun main() {
    println(minDistance("b", "ao"))
}